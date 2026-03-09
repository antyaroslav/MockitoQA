public class MovieManager {
    private String[] movies;
    private int size;
    private int limit;

    public MovieManager() {
        this.limit = 5;
        this.movies = new String[0];
        this.size = 0;
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movies = new String[0];
        this.size = 0;
    }

    public void add(String movie) {
        String[] tmp = new String[size + 1];
        for (int i = 0; i < size; i++) {
            tmp[i] = movies[i];
        }
        tmp[size] = movie;
        movies = tmp;
        size++;
    }

    public String[] findAll() {
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = movies[i];
        }
        return result;
    }

    public String[] findLast() {
        int resultLength = Math.min(size, limit);

        if (resultLength < 0) {
            resultLength = 0;
        }

        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[size - 1 - i];
        }

        return result;
    }
}