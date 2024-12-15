package service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class ReviewService extends ProductReviewServiceGrpc.ProductReviewServiceImplBase {
    //sendet
    @Override
    public void addReview(service.ProductReviewServiceOuterClass.AddReviewRequest request,
                          io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.AddReviewResponse> responseObserver) throws IOException, ParseException {
        responseObserver.onNext(addResponseBuilder(request));
        responseObserver.onCompleted();
    }
    public ProductReviewServiceOuterClass.AddReviewResponse addResponseBuilder (service.ProductReviewServiceOuterClass.AddReviewRequest request) throws IOException, ParseException {
        addReviewAndRating(request.getProdid(),request.getReview(),request.getRating());
        String [] reviews = getProdReviews(request.getProdid());
        long [] ratings = getProdRatings(request.getProdid());
        boolean success;
        if(reviews[reviews.length-1].equals(request.getReview()) && (ratings[ratings.length-1] == request.getRating())){
            success = true;
        }else{
            success = false;
        }

        ProductReviewServiceOuterClass.AddReviewResponse response = ProductReviewServiceOuterClass.AddReviewResponse.newBuilder().setSuccess(success).build();
        return response;
    }

    @Override
    public void getReviews(service.ProductReviewServiceOuterClass.GetReviewsRequest request,
                           io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetReviewsResponse> responseObserver) throws IOException, ParseException {
        responseObserver.onNext(getReviewsResponseBuilder(request));
        responseObserver.onCompleted();
    }
    public ProductReviewServiceOuterClass.GetReviewsResponse getReviewsResponseBuilder (ProductReviewServiceOuterClass.GetReviewsRequest request) throws IOException, ParseException {
       ProductReviewServiceOuterClass.GetReviewsResponse response = ProductReviewServiceOuterClass.GetReviewsResponse.newBuilder().build();
        for (int i = 0; i < (getProdReviews(request.getProdid()).length);i++){
            response.toBuilder().setReviews(i ,getProdReviews(request.getProdid())[i]);
        }
        for (int i = 0; i< (getProdRatings(request.getProdid()).length); i++){
            response.toBuilder().setRatings(i, getProdRatings(request.getProdid())[i]);
        }
        return response;
    }
    @Override
    public void getAverageRating(service.ProductReviewServiceOuterClass.GetAverageRatingRequest request,
                                 io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetAverageRatingResponse> responseObserver) throws IOException, ParseException {
        responseObserver.onNext(getAverageRatingResponseBuilder(request));
        responseObserver.onCompleted();
    }

    public ProductReviewServiceOuterClass.GetAverageRatingResponse getAverageRatingResponseBuilder (ProductReviewServiceOuterClass.GetAverageRatingRequest request) throws IOException, ParseException {
        ProductReviewServiceOuterClass.GetAverageRatingResponse response = ProductReviewServiceOuterClass.GetAverageRatingResponse.newBuilder().setAverageRating(getAvarageProdRating(request.getProdid())[0]).setReviewCount((int) getAvarageProdRating(request.getProdid())[1]).build();
        return response;
    }


    public long[]  getAvarageProdRating (String prodid) throws IOException, ParseException {
        Path path = Paths.get("demo.json");
        Object json = new JSONParser().parse(new FileReader(path.toRealPath().toString() ));
        JSONArray products =  ((JSONArray) ((JSONObject)(json)).get("productReviews"));
        JSONArray prodt = new JSONArray();
        for (int i =0; i<products.toArray().length; i++){
            if (((JSONObject)(products.get(i))).get("prodid").equals(prodid)){
                prodt =(JSONArray) ((JSONObject)  ((JSONArray) ((JSONObject)(json)).get("productReviews")).get(i)).get("rating");
            }
        }
        long Avgrating = 0;
        for (int i =0; i<prodt.toArray().length; i++){
            Avgrating= Avgrating + (long) prodt.get(i);
        }
        return new long[]{Avgrating/prodt.toArray().length,  prodt.toArray().length};
    }

    private void addReviewAndRating(String prodID, String review, long rating) throws IOException, ParseException {
        Path path = Paths.get("demo.json");

        FileReader reader = new FileReader(path.toRealPath().toString() );

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        List<String> reviews = new ArrayList<>();
        List<Long> ratings = new ArrayList<>();

        for (int i =0; i <getProdReviews(prodID).length; i++){
            reviews.add(i,getProdReviews(prodID)[i]);
        }
        for (int i =0; i <getProdRatings(prodID).length; i++){
            ratings.add(i,getProdRatings(prodID)[i]);
        }
        ratings.add(rating);
        reviews.add(review);

        JSONArray products =  ((JSONArray) ((jsonObject)).get("productReviews"));
        JSONObject newobj = new JSONObject();
        newobj.put("review", reviews);
        newobj.put("rating", ratings);
        newobj.put("prodid", prodID);
        System.out.println(newobj);
        JSONArray newProducts = new JSONArray();

        for (int i =0; i<products.toArray().length; i++){
            if (((JSONObject)(products.get(i))).get("prodid").equals(prodID)){
                newProducts.add(newobj);
            }else{
                newProducts.add(products.get(i));
            }
        }
        System.out.println(jsonObject);
        jsonObject.put("productReviews", newProducts);
        System.out.println(jsonObject);
        FileWriter writer = new FileWriter(path.toRealPath().toString(),false);
        writer.write(jsonObject.toString());
        writer.close();
        //find product and add review

    }

    public String[] getProdReviews(String prodid) throws IOException, ParseException {
        Path path = Paths.get("demo.json");
        Object json = new JSONParser().parse(new FileReader(path.toRealPath().toString() ));
        JSONArray products =  ((JSONArray) ((JSONObject)(json)).get("productReviews"));
        JSONArray prodt = new JSONArray();
        for (int i =0; i<products.toArray().length; i++){
            if (((JSONObject)(products.get(i))).get("prodid").equals(prodid)){
                prodt =(JSONArray) ((JSONObject)  ((JSONArray) ((JSONObject)(json)).get("productReviews")).get(i)).get("review");
            }
        }
        String [] reviews = new String[prodt.toArray().length];
        for (int i =0; i<prodt.toArray().length; i++){
            reviews[i] = (String) prodt.get(i);
        }
        return reviews;
    }
    //Fragt nach Product id, gibt alle ratings des Products zurück
    public long[] getProdRatings(String prodid) throws IOException, ParseException {
        Path path = Paths.get("demo.json");
        Object json = new JSONParser().parse(new FileReader(path.toRealPath().toString() ));
        JSONArray products =  ((JSONArray) ((JSONObject)(json)).get("productReviews"));
        JSONArray prodt = new JSONArray();
        for (int i =0; i<products.toArray().length; i++){
            if (((JSONObject)(products.get(i))).get("prodid").equals(prodid)){
                prodt =(JSONArray) ((JSONObject)  ((JSONArray) ((JSONObject)(json)).get("productReviews")).get(i)).get("rating");
            }
        }
        long [] ratings = new long[prodt.toArray().length];
        for (int i =0; i<prodt.toArray().length; i++){
            ratings[i] = (long) prodt.get(i);
        }
        return ratings;
    }



}


