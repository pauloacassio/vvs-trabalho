package dev.paulo;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CafeResourceTest {

    @Test
    public void testListAllCafes() {
        given()
          .when().get("/cafe/list")
          .then()
             .statusCode(200);
    }
}
