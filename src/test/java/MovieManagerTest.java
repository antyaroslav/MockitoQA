import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void shouldAddMovies() {
        MovieManager manager = new MovieManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");

        String[] expected = {"Бладшот", "Вперёд", "Отель \"Белград\""};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldReturnEmptyArrayWhenNoMovies() {
        MovieManager manager = new MovieManager();

        String[] result = manager.findAll();
        assertEquals(0, result.length);
    }

    @Test
    void shouldReturnAllMoviesInOrder() {
        MovieManager manager = new MovieManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");
        manager.add("Джентльмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] expected = {
                "Бладшот",
                "Вперёд",
                "Отель \"Белград\"",
                "Джентльмены",
                "Человек-невидимка",
                "Тролли. Мировой тур",
                "Номер один"
        };

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldReturnLast5MoviesInReverseOrderByDefault() {
        MovieManager manager = new MovieManager();

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
                "Отель \"Белград\""
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnAllMoviesInReverseOrderWhenLessThanLimit() {
        MovieManager manager = new MovieManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");

        String[] expected = {
                "Отель \"Белград\"",
                "Вперёд",
                "Бладшот"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnEmptyArrayForFindLastWhenNoMovies() {
        MovieManager manager = new MovieManager();

        String[] result = manager.findLast();
        assertEquals(0, result.length);
    }

    @Test
    void shouldReturnSingleMovieForFindLast() {
        MovieManager manager = new MovieManager();

        manager.add("Бладшот");

        String[] expected = {"Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldReturnExactLimitWhenSizeEqualsLimit() {
        MovieManager manager = new MovieManager(3);

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");

        String[] expected = {
                "Отель \"Белград\"",
                "Вперёд",
                "Бладшот"
        };

        assertArrayEquals(expected, manager.findLast());
    }
}