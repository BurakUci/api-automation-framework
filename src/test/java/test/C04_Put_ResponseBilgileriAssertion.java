package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertion {


    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine aşağıdaki
    Json formatındaki body ile bir PUT request gönderdiğimizde
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

    dönen Response’un,

    status code’unun 200,
    ve content type’ının application/json; charset=utf-8,
    ve Server isimli Header’ın değerinin cloudflare,
    ve status Line’in HTTP/1.1 200 OK
     */

    @Test
    public void put01(){


        String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody =new JSONObject();

        reqBody.put("title","Ahmet")
        .put("body","Merhaba")
        .put("userId",10)
        .put("id",70);


        Response response=given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                put(url);

        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");

    }










}
