package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTesti {


    /*
https://jsonplaceholder.typicode.com/posts
url’ine aşağıdaki body ile bir POST request gönderdiğimizde

{
    "title":"API",
    "body":"API ogrenmek ne guzel",
    "userId":10,
}

dönen Response’un,

status code’unun 201,
ve content type’ının application/json
ve Response Body’sindeki,
"title"’ın "API" olduğunu
"userId" değerinin 100’den küçük olduğunu
"body"’nin "API" kelimesi içerdiğini
test edin.
 */


    @Test
    public void post01(){

        String url ="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody =new JSONObject();

        reqBody.put("title","API")
        .put("body","API ogrenmek ne guzel")
        .put("userId",10);

        Response response= given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));








    }








}
