package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {



   /*
 https://restful-booker.herokuapp.com/booking/10 url’ine
 bir GET request gönderdiğimizde dönen Response’un,
 status code’unun 200,
 ve content type’inin application/json; charset=utf-8,
 ve Server isimli Header’ın değerinin Heroku,
 ve status Line’ın HTTP/1.1 200 OK
*/

     @Test
     public  void get01() {
         String url = "https://restful-booker.herokuapp.com/booking/10";

         Response response = given().when().get(url);

         response.then().
                 assertThat().
                 statusCode(200).
                 contentType("application/json; charset=utf-8").
                 header("Server","Heroku").
                 statusLine("HTTP/1.1 200 OK");


     }

}
