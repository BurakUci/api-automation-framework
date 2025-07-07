package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {


    /*
 https://restful-booker.herokuapp.com/booking/10 url’ine
 bir GET request gönderdiğimizde dönen Response’un,
 status code’unun 200,
 ve content type’inin application/json; charset=utf-8,
 ve Server isimli Header’ın değerinin Cowboy,
 ve status Line’ın HTTP/1.1 200 OK
 ve response süresinin 5 sn’den kısa olduğunu manuel olarak test ediniz.
*/

    // 1 - Gonderecegimiz Request için gerekli olan URL ve ihtiyacımız varsa Request Body hazırla
// 2 - Eğer soruda bize verilmişse Expected Data hazırla
// 3 - Bize dönen Response’i Actual Data olarak kaydet
// 4 - Expected Data ile Actual Data’yı karşılaştırmamız yani Assertion yapmamız gerek


    @Test
    public void get01(){

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response =given().when().get(url);

        response.prettyPrint();

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Content type : " + response.getContentType());
        System.out.println("Server Header Degeri : " + response.getHeader("Server"));
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Response Suresi : " + response.getTime());



    }

}
