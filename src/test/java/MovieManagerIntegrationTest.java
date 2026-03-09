import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerIntegrationTest {

    @Test
    void shouldWorkWithFullListOfMovies() {
        MovieManager manager = new MovieManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");
        manager.add("Джентльмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] allMovies = manager.findAll();
        assertEquals(7, allMovies.length);
        assertEquals("Бладшот", allMovies[0]);
        assertEquals("Номер один", allMovies[6]);

        String[] lastMovies = manager.findLast();
        assertEquals(5, lastMovies.length);
        assertEquals("Номер один", lastMovies[0]);
        assertEquals("Тролли. Мировой тур", lastMovies[1]);
        assertEquals("Человек-невидимка", lastMovies[2]);
        assertEquals("Джентльмены", lastMovies[3]);
        assertEquals("Отель \"Белград\"", lastMovies[4]);
    }

    @Test
    void shouldWorkWithCustomLimit7ForFullList() {
        MovieManager manager = new MovieManager(7);

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель \"Белград\"");
        manager.add("Джентльмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");

        String[] lastMovies = manager.findLast();
        assertEquals(7, lastMovies.length);
        assertEquals("Номер один", lastMovies[0]);
        assertEquals("Бладшот", lastMovies[6]);
    }
}