package io.egen.rentalflix;

/**
 * Entity representing a movie. Fields: id, title, year, language
 */
public class Movie {
	private Integer movieId;
	private String name;
	private boolean isRented;

	/**
	 * @param i
	 * @param string
	 * @param false1
	 */
	public Movie(int id, String name, Boolean notRented) {
		this.movieId = id;
		this.name = name;
		this.isRented = notRented;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isRented ? 1231 : 1237);
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", isRented=" + isRented + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Movie other = (Movie) obj;
		if (isRented != other.isRented) {
			return false;
		}
		if (movieId == null) {
			if (other.movieId != null) {
				return false;
			}
		} else if (!movieId.equals(other.movieId)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
