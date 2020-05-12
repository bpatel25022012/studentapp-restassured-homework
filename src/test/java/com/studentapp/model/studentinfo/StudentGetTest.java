package com.studentapp.model.studentinfo;

import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created By Bhavesh
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsDetails(){
       Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test

    public void searchStudentById(){
        Response response = given()
                .when()
                .get("85");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test

    public void searchStudentByProgramme(){
       given()
        .param("programme","Financial Analysis")
                .when()
                .get("/list")
               .then()
               .body("programme.size()",equalTo(10));



    }
    @Test
    public void searchStudentByProgrammeAndLimit(){
       given()
                .param("programme","Financial Analysis")
                .param("limit",4)
                .when()
                .get("/list")
                .then()
                .body("programme.size()",equalTo(4));


    }

}
