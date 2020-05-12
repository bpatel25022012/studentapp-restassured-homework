package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;

import org.junit.Test;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


/**
 * Created By Bhavesh
 */
public class StudentPatchTest extends TestBase {
    String email = "Amit" + getRandomString(4) +"@gmail.com";

    @Test
    public void updateStudentEmailOnly(){
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail(email);

    given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .patch("/83")
               .then();
                get("/list").then().body("[82].email",equalTo(email));






    }
}
