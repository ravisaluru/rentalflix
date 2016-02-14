package io.egen.rentalflix;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Service implementing IFlix interface You can use any Java collection type to
 * store movies
 */
public class MovieService implements IFlix {

	private static ConcurrentHashMap<Integer, Movie> movieList = new ConcurrentHashMap<Integer, Movie>();

	/*
	 * (non-Javadoc)
	 *
	 * @see io.egen.rentalflix.IFlix#findAll()
	 */
	@Override
	public List<Movie> findAll() {
		return movieList.values().stream().collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see io.egen.rentalflix.IFlix#findByName(java.lang.String)
	 */
	@Override
	public List<Movie> findByName(String name) {
		return movieList.values().stream().filter(movie -> movie.getName().equals(name)).collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see io.egen.rentalflix.IFlix#create(io.egen.rentalflix.Movie)
	 */
	@Override
	public Movie create(Movie movie) {
		movieList.put(movie.getMovieId(), movie);
		return movie;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see io.egen.rentalflix.IFlix#update(io.egen.rentalflix.Movie)
	 */
	@Override
	public Movie update(Movie movie) {
		if (movieList.get(movie.getMovieId()) != null) {
			movieList.put(movie.getMovieId(), movie);
		} else {
			throw new IllegalArgumentException("No such movie was found");
		}
		return movie;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see io.egen.rentalflix.IFlix#delete(int)
	 */
	@Override
	public Movie delete(int id) {
		Movie movie = movieList.get(id);
		if (movie != null) {
			movieList.remove(id);
		} else {
			throw new IllegalArgumentException("No such movie was found");
		}
		return movie;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see io.egen.rentalflix.IFlix#rentMovie(int, java.lang.String)
	 */
	@Override
	public boolean rentMovie(int movieId, String user) {
		Movie movie = movieList.get(movieId);
		boolean canMovieBeRented = false;
		if (movie.isRented()) {
			throw new IllegalArgumentException("This movie " + movie.getName() + " has already been rented");
		} else {
			movie.setRented(Boolean.TRUE);
			update(movie);
			canMovieBeRented = Boolean.TRUE;
		}
		return canMovieBeRented;
	}

}
