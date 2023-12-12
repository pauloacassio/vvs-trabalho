package dev.paulo;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@QuarkusTest
class CafeteriaResourceTest {

    // Para a realização dos testes, primeiro precisamos incluir uma cafeteria.
    @BeforeEach
    void createCafeteria() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("nome", "Cafeteria Teste")
            .formParam("endereco", "Endereco Teste")
            .when()
            .post("/cafeteria/save")
            .then()
            .statusCode(200);
    }

    // Teste para o endpoint /cafeteria/save para salvar uma cafeteria
    @Test
    void testSaveCafeteria() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("nome", "Cafeteria Teste Save")
            .formParam("endereco", "Endereco Teste Save")
            .when()
            .post("/cafeteria/save")
            .then()
            .statusCode(200);
    }

    // Teste para o endpoint /cafeteria/list para listar todas as cafeterias
    @Test
    void testListAllCafeterias() {
        given()
            .when().get("/cafeteria/list")
            .then()
            .statusCode(200);
    }

    // Teste para o endpoint /cafeteria/list/{id} para listar uma cafeteria por ID
    @Test
    void testListCafeteriaById() {
        Long cafeteriaId = 1L;

        given()
            .pathParam("id", cafeteriaId)
            .when().get("/cafeteria/list/{id}")
            .then()
            .statusCode(204);         
    }

    // Teste para o endpoint /cafeteria/delete/{id} para deletar a cafeteria de ID 1
    @Test
    void testDeleteCafeteriaById() {
        Long cafeteriaId = 1L;

        given()
            .pathParam("id", cafeteriaId)
            .when().delete("/cafeteria/delete/{id}")
            .then()
            .statusCode(200);
    }
}