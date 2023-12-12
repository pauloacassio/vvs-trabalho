package dev.paulo;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CafeteriaResourceTest {

    @Test
    public void testSaveCafeteria() {
        given()
            .when()
            .contentType("application/x-www-form-urlencoded")
            .formParam("nome", "Cafeteria Test")
            .formParam("endereco", "Endereco Test")
            .post("/cafeteria/save")
            .then()
                .statusCode(200);
    }

    @Test
    public void testListAllCafeterias() {
        given()
            .when().get("/cafeteria/list")
            .then()
                .statusCode(200);
    }
}

