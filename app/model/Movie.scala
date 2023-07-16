package model

import play.api.libs.json._

//import play.api.libs.json.{JsValue, Json, Writes}

case class Movie(title: String, year: Int, rating: Double)

object Movie {

  implicit val movieWrites = new Writes[Movie] {
    override def writes(o: Movie): JsValue = Json.obj(
      "title" -> o.title,
      "year" -> o.year,
      "rating" -> o.rating
    )
  }

}
