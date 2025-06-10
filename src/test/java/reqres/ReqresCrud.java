package reqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresCrud {

    @Test(priority = 1)
    void getUser()
    {
        Response response = RestAssured.given().baseUri("https://reqres.in")
                .basePath("/api/users/3")
                .when()
                .get();

        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode()+" "+response.statusLine());
        System.out.println(response.getTime());

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 2)
    void getAllUser()
    {
        Response response = RestAssured.given().baseUri("https://reqres.in")
                .basePath("/api/users")
                .header("x-api-key","reqres-free-v1")
                .queryParam("page",1)
                .when()
                .get();

        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode()+" "+response.statusLine());
        System.out.println(response.getTime());

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 3)
    void createUser()
    {
        JSONObject payload = new JSONObject();
        payload.put("name","rajesh");
        payload.put("job","tester");

        Response response = RestAssured.given().baseUri("https://reqres.in")
                .basePath("/api/users")
                .header("x-api-key","reqres-free-v1")
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .body(payload.toJSONString())
                .when()
                .post();

        System.out.println(response.asPrettyString());
        System.out.println(response.body().asPrettyString());
        System.out.println(response.statusCode()+" "+response.statusLine());
        System.out.println(response.getTime());

        Assert.assertEquals(response.statusCode(),201);
    }

    @Test(priority = 4)
    void updateUser()
    {
        JSONObject payload = new JSONObject();
        payload.put("name","rajesh");
        payload.put("job","QA");

        Response response = RestAssured.given().baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .header("x-api-key","reqres-free-v1")
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .body(payload.toJSONString())
                .when()
                .put();

//        System.out.println(response.asPrettyString());
        System.out.println(response.body().asPrettyString());
        System.out.println(response.statusCode()+" "+response.statusLine());
        System.out.println(response.getTime());

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 5)
    void patchUser()
    {
        JSONObject payload = new JSONObject();
        payload.put("name","rajesh");
        payload.put("job","QA");

        Response response = RestAssured.given().baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .header("x-api-key","reqres-free-v1")
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .body(payload.toJSONString())
                .when()
                .patch();

//        System.out.println(response.asPrettyString());
        System.out.println(response.body().asPrettyString());
        System.out.println(response.statusCode()+" "+response.statusLine());
        System.out.println(response.getTime());

        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 6)
    void deleteUser()
    {
        Response response = RestAssured.given().baseUri("https://reqres.in")
                .basePath("/api/users/2")
                .header("x-api-key","reqres-free-v1")
                .header("Content-type","application/json")
                .contentType(ContentType.JSON)
                .when()
                .delete();

//        System.out.println(response.asPrettyString());
        System.out.println(response.body().asPrettyString());
        System.out.println(response.statusCode()+" "+response.statusLine());
        System.out.println(response.getTime());

        Assert.assertEquals(response.statusCode(),200);
    }
}
