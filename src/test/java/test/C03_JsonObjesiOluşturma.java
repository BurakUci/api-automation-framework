package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOluşturma {

    /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.

{
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":1
}
*/

    @Test
    public void jsonObject01(){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title","Ahmet").put("body","Merhaba").put("userId",1);
        System.out.println(jsonObject);


    }

    @Test
    public void jsonObje02(){

    /*
        {
            "firstname":"Jim",
            "additionalneeds":"Breakfast",
            "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
            },
            "totalprice":111,
            "depositpaid":true,
            "lastname":"Brown"
        }
     */

        JSONObject jsonObject = new JSONObject();
        JSONObject bookingdates = new JSONObject();

        bookingdates.put( "checkin","2018-01-01").put("checkout","2019-01-01");

        jsonObject.put("firstname","Jim").
                put("additionalneeds","Breakfast").
                put("bookingdates",bookingdates).
                put("totalprice",111).
                put("depositpaid",true).
                put("lastname","Brown");

        System.out.println(jsonObject);

    }










}
