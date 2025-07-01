package com.github.sjacek.graphql.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@QuarkusTest
public class BookResourceTest {

    @Test
    void testGetBooks() {
        RestAssured.given()
                .headers("Content-Type", JSON, "OK", JSON)
                .when()
                .contentType("application/json")
                .body(new String("""
                {
                    "query": "{
                        books {
                            id
                            title
                            authorId
                            pageCount
                        }
                    }"
                }
                """))
                .post("/graphql")
                .then().log().ifValidationFails()
                .body("data.books.size()", is(36))
                .body("errors", nullValue());
    }

	@Test
	void testGetBookById() {
		RestAssured.given()
				.headers("Content-Type", JSON, "OK", JSON)
				.when()
				.contentType("application/json")
				.body("""
                        {
                        	"query": "{
                        	    bookById(id: \\"%s\\") {
                        	        id
                        	        title
                                    authorId
                                    pageCount
                                }
                        	}"
                        }
                        """
						.formatted("book-1"))
				.post("/graphql")
				.then().log().ifValidationFails()
				.body("data.bookById.id", is("book-1"))
				.body("data.bookById.title", is("Effective Java"))
				.body("data.bookById.authorId", is("author-1"))
				.body("data.bookById.pageCount", is(416))
				.body("errors", nullValue());
	}

	@Test
	void testAddBook() {
	}
}
