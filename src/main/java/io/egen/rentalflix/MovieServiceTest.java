/**
 *
 */
package io.egen.rentalflix;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ravi
 *
 */
public class MovieServiceTest {

	MovieService service = new MovieService();

	@Before
	public void initialize() {
		Movie movie1 = new Movie(1, "LOTR", Boolean.FALSE);
		Movie movie2 = new Movie(2, "MI4", Boolean.FALSE);
		Movie movie3 = new Movie(3, "Avengers", Boolean.FALSE);
		Movie movie4 = new Movie(4, "Iron-Man", Boolean.FALSE);
		Movie movie5 = new Movie(5, "National-Treasure", Boolean.FALSE);
		Movie movie6 = new Movie(6, "Batman", Boolean.FALSE);
		Movie movie10 = new Movie(10, "LOTR", Boolean.FALSE);

		service.create(movie10);
		service.create(movie1);
		service.create(movie2);
		service.create(movie3);
		service.create(movie4);
		service.create(movie5);
		service.create(movie6);
	}

	/**
	 * Test method for {@link io.egen.rentalflix.MovieService#findAll()}.
	 */
	@Test
	public void testFindAll() {
		assertNotNull(service.findAll());
	}

	/**
	 * Test method for
	 * {@link io.egen.rentalflix.MovieService#findByName(java.lang.String)}.
	 */
	@Test
	public void testFindByName() {
		assertNotNull(service.findByName("LOTR"));
		List<Movie> movies = service.findByName("LOTR");
		movies.forEach(System.out::println);

	}

	/**
	 * Test method for
	 * {@link io.egen.rentalflix.MovieService#create(io.egen.rentalflix.Movie)}.
	 */
	@Test
	public void testCreate() {
		assertNotNull(service.create(new Movie(7, "Pirates", Boolean.FALSE)));
	}

	/**
	 * Test method for
	 * {@link io.egen.rentalflix.MovieService#update(io.egen.rentalflix.Movie)}.
	 */
	@Test
	public void testUpdate() {
		Movie movie1 = new Movie(3, "Avengers", Boolean.TRUE);
		assertNotNull((service.findByName(movie1.getName())));
		assertNotNull(service.update(movie1));
		assertTrue(movie1.equals((service.findByName(movie1.getName()).get(0))));
	}

	/**
	 * Test method for {@link io.egen.rentalflix.MovieService#delete(int)}.
	 */
	@Test
	public void testDelete() {
		assertNotNull(service.delete(6));
	}

	/**
	 * Test method for
	 * {@link io.egen.rentalflix.MovieService#rentMovie(int, java.lang.String)}.
	 */
	@Test(
			expected = IllegalArgumentException.class)
	public void testRentMovie() {
		assertTrue(service.rentMovie(1, "test"));
		assertFalse(service.rentMovie(1, "test"));
	}

}
