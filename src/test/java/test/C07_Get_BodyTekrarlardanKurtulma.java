package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {

    /*
https://restful-booker.herokuapp.com/booking/10 url’ine
bir GET request gönderdiğinizde dönen Response’un,

status code’unun 200,
ve content type’ının application/json; charset=utf-8,
ve response body’sindeki
    "firstname"in,"Mark",
    ve "lastname"in,"Jones",
    ve "totalprice"in, 946,
    ve "depositpaid"in,true,
    ve "additionalneeds"in,"Breakfast"

olduğunu test edin
 */

    @Test
    public void get01(){

        String url ="https://restful-booker.herokuapp.com/booking/10";

        Response response =given().when().get(url);
        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                body("firstname", equalTo("Mark")
                        , "lastname", equalTo("Jones")
                        ,"totalprice", equalTo(946)
                        ,"depositpaid", equalTo(true)
                        ,"additionalneeds", equalTo("Breakfast"));




    }


}
