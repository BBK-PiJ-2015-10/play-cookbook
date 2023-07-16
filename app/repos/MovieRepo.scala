package repos

import model.Movie

object MovieRepo {

  def getMovies(): Seq[Movie] = List(Movie("Top Gun",1987,4.5),
    Movie("Rocky",1985,5.0),
    Movie("Robocop",1985,4.5)
  )

}
