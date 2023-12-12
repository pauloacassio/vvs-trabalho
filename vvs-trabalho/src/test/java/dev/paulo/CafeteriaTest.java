package dev.paulo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CafeteriaTest {

    @Test
    public void testSetAndGetNome() {
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setNome("Cafeteria Teste");
        assertEquals("Cafeteria Teste", cafeteria.getNome());
    }

    @Test
    public void testSetAndGetEndereco() {
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setEndereco("Endereço Teste");
        assertEquals("Endereço Teste", cafeteria.getEndereco());
    }

    // Outros testes para os métodos set e get de outras propriedades

    @Test
    public void testAddCafeToCafeteria() {
        Cafe cafe = new Cafe();
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setNome("Cafeteria Teste");

        cafe.setNome("Café Teste");
        cafe.setNota(4);
        cafe.setCafeteria(cafeteria);

        assertEquals(0, cafeteria.getCafes().size()); // Verifica se a cafeteria está vazia antes de adicionar o café
        cafeteria.addCafe(cafe);
        assertEquals(1, cafeteria.getCafes().size()); // Verifica se o café foi adicionado à cafeteria
        assertEquals(cafeteria, cafe.getCafeteria()); // Verifica se a cafeteria do café está correta
    }    

}

