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









}
