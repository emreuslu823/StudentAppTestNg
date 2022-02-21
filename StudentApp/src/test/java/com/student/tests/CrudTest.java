package com.student.tests;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


@Story("This is a Crud testing story")

public class CrudTest extends TestBase {

    RequestFactory request = new RequestFactory();

    @Story("This is a Crud testing story")
    @Feature("This is a test to get all students from database")
    @Test (groups = "SmokeTest")

    public void getAllStudent() {

        request.getAllStudents().
                then().
                statusCode(200);
    }

    @Story("This is aCrud Testing story")
    @Feature("This a test to create and verify new student")
    @Test

    public void createNewStudent(){

        Faker fakeData = new Faker();

        String firstName =fakeData.name().firstName();
        String lastName= fakeData.name().lastName();
        String email = fakeData.internet().emailAddress();
        String programme = fakeData.job().title();
        List<String> courses = new ArrayList<String>();
        courses.add("Analytics");
        courses.add("C++");
        courses.add("Java");
        request.createNewStudent("",firstName,lastName,email,programme,courses).
                then().
                spec(SpecificationFactory.getGenericResponseSpec()).
                statusCode(201);
    }
}
