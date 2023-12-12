package dev.paulo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CafeTest {

    @Test
    public void testSetAndGetNome() {
        Cafe cafe = new Cafe();
        cafe.setNome("Café Teste");
        assertEquals("Café Teste", cafe.getNome());
    }

    @Test
    public void testSetAndGetNota() {
        Cafe cafe = new Cafe();
        cafe.setNota(4);
        assertEquals(4, cafe.getNota());
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

        // Testar se o café é marcado como favorito corretamente
        @Test
        public void testSetAndGetFavorito() {
            Cafe cafe = new Cafe();
            cafe.setFavorito(true);
            assertTrue(cafe.getFavorito());
        }
}