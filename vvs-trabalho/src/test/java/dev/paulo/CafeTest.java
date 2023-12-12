package dev.paulo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CafeTest {

    // Testando Getters e Setters
    // Nome
    @Test
    void testSetAndGetNome() {
        Cafe cafe = new Cafe();
        cafe.setNome("Café Teste");
        assertEquals("Café Teste", cafe.getNome());
    }

    // Nota
    @Test
    void testSetAndGetNota() {
        Cafe cafe = new Cafe();
        cafe.setNota(4);
        assertEquals(4, cafe.getNota());
    }

    // Tipo
    @Test
    void testSetAndGetTipo() {
        Cafe cafe = new Cafe();
        cafe.setTipo("Amargo");
        assertEquals("Amargo", cafe.getTipo());
    }

    // Favorito (verificando se é true)
    @Test
    void testSetAndGetFavorito() {
        Cafe cafe = new Cafe();
        cafe.setFavorito(true);
        assertTrue(cafe.getFavorito());
    }

    // Adiciona um café a uma cafeteria
    @Test
    void testAddCafeToCafeteria() {
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
    
    // Tenta adicionar um café a uma cafeteria nula
    @Test
    void testAddCafeWithNullCafeteria() {
        Cafe cafe = new Cafe();
        cafe.setNome("Café Teste");
        cafe.setNota(4);
        cafe.setTipo("Expresso");
        cafe.setFavorito(true);
        cafe.setCafeteria(null);
    
        assertNull(cafe.getCafeteria()); // Verifica se a cafeteria do café é nula
    }
}