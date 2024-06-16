package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hola from Quarkus REST"));
    }

    @Test
    void testGreetingEndpoint() {
        var name = "Bella";
        given()
                .pathParam("name", name)
                .when().get("/hello/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("hello Bella"));
    }

}