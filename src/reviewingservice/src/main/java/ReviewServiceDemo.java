import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewServiceDemo {
    //fragt nach Product id, gibt Avaragerating und Anzahl ratings von product
    public static long[]  getAvarageProdRating (String prodid) throws IOException, ParseException {
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
    public static String[] getProdReviews(String prodid) throws IOException, ParseException {
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
    public  static  long[] getProdRatings(String prodid) throws IOException, ParseException {
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
    /*test funktionen
    public static void toString(String[] reviews){
        for (String review : reviews) {
            System.out.println(review);
        }
    }
    public static void toString(long[] ratings){
        System.out.println("Avarage Rating: "+ratings[0]);
        System.out.println("Total ratings: " +ratings[1]);
    }
    public static void Ratings(long[] ratings){
        for (long rating : ratings){
            System.out.println(rating);
        }
    }

     */
    //Fragt nach Product id, neues review und rating und ändert sie dann in den json
    public  static void addReviewandRating(String prodID, String review, long rating) throws IOException, ParseException {
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

}