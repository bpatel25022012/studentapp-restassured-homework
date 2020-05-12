package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created By Bhavesh
 */
public class StudentDeleteTest extends TestBase {

    @Test

    public void deleteStudentById(){
        Response response= given()
                .when()
                .delete("/97");
        response.then().statusCode(204);





    }
}
