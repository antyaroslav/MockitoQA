import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerCustomLimitTest {

    @Test
    void shouldUseCustomLimitOf3() {
        MovieManager manager = new MovieManager(3);

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");
        manager.add("Джентльмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] expected = {
                "Номер один",
                "Тролли. Мировой тур",
                "Человек-невидимка"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldUseCustomLimitOf7() {
        MovieManager manager = new MovieManager(7);

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");
        manager.add("Джентльмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] expected = {
                "Номер один",
                "Тролли. Мировой тур",
                "Человек-невидимка",
                "Джентльмены",
                "Отель \"Белград\"",
                "Вперёд",
                "Бладшот"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldUseCustomLimitOf10WithOnly7Movies() {
        MovieManager manager = new MovieManager(10);

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");
        manager.add("Джентльмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] expected = {
                "Номер один",
                "Тролли. Мировой тур",
                "Человек-невидимка",
                "Джентльмены",
                "Отель \"Белград\"",
                "Вперёд",
                "Бладшот"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldHandleZeroLimit() {
        MovieManager manager = new MovieManager(0);

        manager.add("Бладшот");
        manager.add("Вперёд");

        String[] result = manager.findLast();
        assertEquals(0, result.length);
    }

    @Test
    void shouldHandleNegativeLimit() {
        MovieManager manager = new MovieManager(-5);

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");

        String[] result = manager.findLast();
        assertEquals(0, result.length);
    }
}