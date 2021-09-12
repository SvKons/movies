package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.CatalogMovies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoviesManagerTest {
    CatalogMovies first = new CatalogMovies(1, 1, "Bloodshot", "thriller" );
    CatalogMovies second = new CatalogMovies(2, 2, "Onward", "cartoon");
    CatalogMovies third = new CatalogMovies(3, 3, "Hotel Belgrad", "comedy");
    CatalogMovies four = new CatalogMovies(4, 4, "The Gentlemen", "thriller");
    CatalogMovies five = new CatalogMovies(5, 5, "The Invisible Man", "horrors ");
    CatalogMovies six = new CatalogMovies(6, 6, "Trolls World Tour", "cartoon");
    CatalogMovies seven = new CatalogMovies(7, 7, "Number One", "comedy");
    CatalogMovies eight = new CatalogMovies(8, 8, "The Smurfs", "cartoon");
    CatalogMovies nine = new CatalogMovies(9, 9, "Interstellar", "fantastic");
    CatalogMovies ten = new CatalogMovies(10, 10, "Tenet", "thriller");
    CatalogMovies eleven = new CatalogMovies(11, 11, "Harry Potter", "fantasy");
    CatalogMovies twelve = new CatalogMovies(11, 11, "The Meg", "fantastic");
    CatalogMovies thirteen = new CatalogMovies(11, 11, "Ford v Ferrari", "biography ");

    @Test
    public void shouldRemoveIfExists() {
        MoviesManager manager = new MoviesManager();
        int idToRemove = 1;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        CatalogMovies[] actual = manager.getAll();
        CatalogMovies[] expected = new CatalogMovies[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowTenMovies() {
        MoviesManager manager = new MoviesManager();

        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);
        manager.add(twelve);
        manager.add(thirteen);

        CatalogMovies[] actual = manager.getAll();
        CatalogMovies[] expected = new CatalogMovies[]{thirteen, twelve, eleven, ten, nine, eight, seven, six, five, four};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMoviesAboveMax() {
        MoviesManager manager = new MoviesManager();

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);

        manager.getLast();

        CatalogMovies[] actual = manager.getLast();
        CatalogMovies[] expected = new CatalogMovies[]{ten, nine, eight, seven, six, five, four,
                third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMoviesBelowMax() {
        MoviesManager manager = new MoviesManager();

        manager.add(eight);
        manager.add(nine);
        manager.add(ten);
        manager.add(eleven);

        manager.getLast();

        CatalogMovies[] actual = manager.getLast();
        CatalogMovies[] expected = new CatalogMovies[]{eleven, ten, nine, eight};

        assertArrayEquals(expected, actual);
    }

}