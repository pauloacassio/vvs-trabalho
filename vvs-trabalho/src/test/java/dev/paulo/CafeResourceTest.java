package dev.paulo;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@QuarkusTest
class CafeResourceTest {

    // Para a realização dos testes, primeiro nós precisamos que seja incluída uma cafeteria.
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

    
    // Para a realização dos testes, primeiro nós precisamos que seja incluída um café.
    @BeforeEach
    void createCafe() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("nome", "Cafe Test")
            .formParam("nota", 5)
            .formParam("tipo", "Espresso")
            .formParam("favorito", true)
            .formParam("cafeteria_id", 1)
            .when()
            .post("/cafe/save")
            .then()
            .statusCode(200);
    }

    // Teste para o endpoint /cafe/save para salvar um café
    @Test
    void testSaveCafe() {        
        given()
            .contentType(ContentType.URLENC)
            .formParam("nome", "Cafe Test")
            .formParam("nota", 5)
            .formParam("tipo", "Forte")
            .formParam("favorito", true)
            .formParam("cafeteria_id", 1)
            .when()
            .post("/cafe/save")
            .then()
            .statusCode(200);
    }

    // Teste para o endpoint /cafe/list para listar os cafés
    @Test
    void testListAllCafes() {
        given()
            .when().get("/cafe/list")
            .then()
            .statusCode(200);
    }

    // Teste para o endpoint /cafe/list/{id} para listar o café de id 1
    @Test
    void testListCafeById() {
        Long cafeId = 1L;

        given()
            .pathParam("id", cafeId)
            .when().get("/cafe/list/{id}")
            .then()
            .statusCode(200);         
    }

    // Teste para o endpoint /cafe/edit/{id} para editar o café de id 1
    @Test
    void testEditCafe() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("id", 1L)
            .formParam("nome", "Cafe Editado")
            .formParam("nota", 4)
            .formParam("tipo", "Cappuccino")
            .formParam("favorito", false)
            .when()
            .put("/cafe/edit")
            .then()
            .statusCode(200);
    }

    // Teste para o endpoint /cafe/delete/{id} para deletar o café de id 1
    @Test
    void testDeleteCafeById() {
        Long cafeId = 1L;

        given()
            .pathParam("id", cafeId)
            .when().delete("/cafe/delete/{id}")
            .then()
            .statusCode(200);
    }
}