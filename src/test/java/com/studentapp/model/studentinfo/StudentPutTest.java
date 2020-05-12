package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created By Bhavesh
 */
public class StudentPutTest extends TestBase {
    String email = "Amit" + getRandomString(4) +"@gmail.com";
    @Test
    public void updateStudentById(){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Bhavesh");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail(email);
        studentPojo.setProgramme("Automation Testing");
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCourses(course);

   given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .put("/63")
                .then();
                 get("/list")
                .then()
                .body("[62].id",equalTo(63))
                .body("[62].firstName",equalTo("Bhavesh"))
                .body("[62].lastName",equalTo("Patel"));


    }




}
