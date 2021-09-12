package ru.netology.manager;

import ru.netology.domain.CatalogMovies;

public class MoviesManager {
    private CatalogMovies[] movies = new CatalogMovies[0];
    private int lastAdded = 10;

    public MoviesManager() {
    }

    public MoviesManager(int lastAdd) {
        if (lastAdd < lastAdded) {
            this.lastAdded = lastAdd;
        } else {
            this.lastAdded = 10;
        }
    }

    public void add(CatalogMovies movie) {
        // создаём новый массив размером на единицу больше
        int length = movies.length + 1;
        CatalogMovies[] tmp = new CatalogMovies[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public CatalogMovies[] getAll() {
        CatalogMovies[] result = new CatalogMovies[movies.length];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    // наивная реализация
    public void removeById(int id) {
        int length = movies.length - 1;
        CatalogMovies[] tmp = new CatalogMovies[length];
        int index = 0;
        for (CatalogMovies movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        // меняем наши элементы
        movies = tmp;
    }

    public CatalogMovies[] getLast() {
        int finalLength = movies.length + 1;

        if (movies.length > lastAdded) {
            finalLength = lastAdded;
        } else {
            finalLength = movies.length;
        }

        CatalogMovies[] result = new CatalogMovies[finalLength];

        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
