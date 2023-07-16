package model

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._

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

  implicit val movieReads : Reads[Movie] = (
      (JsPath \ "title").read[String](minLength[String](2)) and
        (JsPath \ "year").read[Int](min(1920).keepAnd(max(2023))) and
        (JsPath \ "rating").read[Double](min(0d).keepAnd(max(10d)))
    )(Movie.apply _)

}
