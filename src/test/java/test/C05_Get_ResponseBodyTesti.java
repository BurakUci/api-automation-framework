package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Get_ResponseBodyTesti {

    /*
https://jsonplaceholder.typicode.com/posts/44 url’ine bir GET request yolladığınızda
dönen Response’in

    status code’unun 200,
    ve content type’ının ContentType.JSON,
    ve response body’sinde bulunan userId’nin 5,
    ve response body’sinde bulunan title’ın “optio dolor molestias sit”
    olduğunu test edin.
 */


    @Test
    public void get01(){

        String url ="https://jsonplaceholder.typicode.com/posts/44";

        Response response =given().when().get(url);

        response.then().assertThat()
                .contentType(ContentType.JSON)
                .body("userId",Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));


    }



}
