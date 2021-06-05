package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.NativeImageTest;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@NativeImageTest
public class NativeBookResourceIT extends BookResourceTest {

    // Execute the same tests but in native mode.

    @Override
    public void shouldGetABook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when().get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Antonio"))
                .body("genre", is("Information Tech"));
    }
}