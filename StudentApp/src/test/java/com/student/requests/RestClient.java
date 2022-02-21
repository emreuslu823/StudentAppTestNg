package com.student.requests;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestClient extends TestBase {

    public Response doGetRequest(String requestPath) {

        return given().
                when().
                get(requestPath);
    }

    public Response doPostRequest(String uri, Object body) {

        return given().
                contentType(ContentType.JSON).
                spec(SpecificationFactory.logPayloadResponseInfo()).
                when().
                body(body).
                post(uri);
    }

    public Response doGetRequestWithQueryParam(String res, Map<String, String> params) {

        return given().
                queryParams(params).
                when().
                get(res);
    }

    public Response doPutRequest(String res, Object body) {

        return given().
                when().
                body(body).
                get(res);
    }

    public Response doPatchRequest(String res, Object body) {

        return given().
                when().
                body(body).
                patch(res);
    }

    public Response doDeleteRequest(String res) {

        return given().
                when().
                delete(res);
    }
}
