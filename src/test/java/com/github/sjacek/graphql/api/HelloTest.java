package com.github.sjacek.graphql.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@QuarkusTest
public class HelloTest {
    @Test
    void testHello() {
        RestAssured.given()
                .headers("Content-Type", JSON, "OK", JSON)
                .when()
                .contentType("application/json")
                .body("""
				{
					"query": "{
					    sayHello(name: \\"%s\\")
					}"
				}
				""".formatted("Ala"))
                .post("/graphql")
                .then().log().ifValidationFails()
				.body("data.sayHello", is("Hello Ala"))
                .body("errors", nullValue());
    }
}
