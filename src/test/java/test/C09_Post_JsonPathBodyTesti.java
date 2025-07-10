package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;
import static org.hamcrest.Matchers.equalTo;

public class C09_Post_JsonPathBodyTesti {


    /*
  https://restful-booker.herokuapp.com/booking
  url’ine aşağıdaki body’ye sahip
  bir POST request gönderdiğimizde

    {
         "firstname" : "Ali",
         "lastname" : "Bak",
         "totalprice" : 500,
         "depositpaid" : false,
         "bookingdates" : {
             "checkin" : "2021-06-01",
             "checkout" : "2021-06-10"
        },
        "additionalneeds" : "wi-fi"
    }


   dönen Response’un,

   status code’unun 200,
   ve content type’ının application/json; charset=utf-8,
   ve response body’sindeki
       "firstname"in "Ali",
       ve "lastname"in "Bak",
       ve "totalprice"in 500,
       ve "depositpaid"in false,
       ve "checkin" tarihinin 2021-06-01
       ve "checkout" tarihinin 2021-06-10
       ve "additionalneeds"in "wi-fi"

   olduğunu test edin
   */


    @Test
    public void post01(){

        String url ="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates= new JSONObject();
        bookingDates
                .put("checkin" , "2021-06-01")
                .put("checkout" , "2021-06-10");



       JSONObject reqBody = new JSONObject();
       reqBody
               .put("firstname" , "Ali").put("lastname" , "Bak")
               .put("totalprice" , 500).put("depositpaid" , false)
               .put("bookingdates",bookingDates).put( "additionalneeds" , "wi-fi");




        Response response =given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ali")
                        ,"booking.lastname",equalTo("Bak")
                        ,"booking.totalprice",equalTo(500)
                        ,"booking.depositpaid",equalTo(false)
                        ,"booking.bookingdates.checkin",equalTo("2021-06-01")
                        ,"booking.bookingdates.checkout",equalTo("2021-06-10")
                        ,"booking.additionalneeds",equalTo("wi-fi"));








        }

    }










