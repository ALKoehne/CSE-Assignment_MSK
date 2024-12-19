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
    //Grpc methode um AddReview Request zu erfüllen. Braucht eine Request, ruft dann in der Methode die addResponseBuilder Methode auf und ist dann vertig
    @Override
    public void addReview(service.ProductReviewServiceOuterClass.AddReviewRequest request,
                          io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.AddReviewResponse> responseObserver) throws IOException, ParseException {
        responseObserver.onNext(addResponseBuilder(request));
        responseObserver.onCompleted();
    }

    //Methode die da ist um die AddReview Methode zu unterstützen. Braucht einen AddReviewRequest, ruft dann die Methode addReviewRating mit den Werten aus request und sendet dann true oder false wenn es erflogreich war. 
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


    //Grpc Methode die ,die getReview Request erfüllt indem es mithilfe von getReviewsResponseBuilder Methode eine Response liefert
    @Override
    public void getReviews(service.ProductReviewServiceOuterClass.GetReviewsRequest request,
                           io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetReviewsResponse> responseObserver) throws IOException, ParseException {
        responseObserver.onNext(getReviewsResponseBuilder(request));
        responseObserver.onCompleted();
    }


    //Methode, die in der json nach dem Product in der json Datein mithilfe der ProdId sucht, die in der Request beinhaltet ist, und itteriert durch die Reviews Array und Rating array und die in der Response speichert und dann returned.
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

    //Grpc Methode ,die bei einer GetAverageRatingRequest die Average ratings und totale Anzahl an Ratings von einen Product bei einer Request zurücksendet mit hilfe von der getAverageRatingResponseBuilder methode.
    @Override
    public void getAverageRating(service.ProductReviewServiceOuterClass.GetAverageRatingRequest request,
                                 io.grpc.stub.StreamObserver<service.ProductReviewServiceOuterClass.GetAverageRatingResponse> responseObserver) throws IOException, ParseException {
        responseObserver.onNext(getAverageRatingResponseBuilder(request));
        responseObserver.onCompleted();
    }

    //Methode die, die average Rating und Anzahl der Ratings als Response returned mit hilfe von getAvarageProdRating Methode.
    public ProductReviewServiceOuterClass.GetAverageRatingResponse getAverageRatingResponseBuilder (ProductReviewServiceOuterClass.GetAverageRatingRequest request) throws IOException, ParseException {
        ProductReviewServiceOuterClass.GetAverageRatingResponse response = ProductReviewServiceOuterClass.GetAverageRatingResponse.newBuilder().setAverageRating(getAvarageProdRating(request.getProdid())[0]).setReviewCount((int) getAvarageProdRating(request.getProdid())[1]).build();
        return response;
    }

    //Grpc Methoden vertig


    //Methodem die Eine ProdId braucht, sich dann den json file anschaut , nach dem Product filtert mit der richtigen ID, itteriert dann den Rating array uns speichert es in einen temporären array mit dem mann dann die länge berechnen kann und alle Reviews zusammen zählt, returned dann einen Long array wo der erst Element immer der Avrg Rating ist und der zweite immer die totale Anzahl an den Reviews
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

    //Methode ,die Reviews in der json added, braucht dafür die Prod Id, das Review und das Rating. Da jsons immutable sind, nach mein verständnis, kann man das File nicht einfach edditen, sonder man muss eine neue erzeugen, deswegen bin ich als nächstes so vorgegangen: Schaut sich den File an, speichert dann die schon existirende Reviews und Rating von den genauen Product in zwei Arrays, added dann da nochmal die neuen Reviews und Ratings. Dann wird eine neue json Datei mit der selbe FileName und Filepath, coopiert dann alle Producte aus den alten json Datei, ausßer die, die die gegeben Id hat. Die wird dann aus den temporären Arrays, die in der Methode erzeugt wurden und dann in der neue
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
        

    }

    // Methode, die eine ProdId braucht, such dann in dem File nach den genauen Product mitihilfe von der Id, speichert sie dann in einen temporären JsonArray, die dann in einen String Array gespeichert wird und zurückgegeben.
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
    //Methode, die eine Prod Id Braucht, sich dann den File nach den genauen Product durchsucht mithilfe von der Id, speichert dann die Ratings in einen temporären JsonArray, die dann in einen Long Array gespiechert werden und returned.
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


