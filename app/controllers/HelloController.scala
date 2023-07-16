package controllers

import model.{Error, Movie}

import javax.inject._
import play.api._
import play.api.libs.json._
import play.api.mvc._
import repos.MovieRepo
import model.Movie._

@Singleton
class HelloController  @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def sayHello() = Action { implicit request: Request[AnyContent] =>
    Ok("Hello, friend")
  }

  def sayHi(thatName: String) = Action { implicit request: Request[AnyContent] =>
    Ok(s"Hi my friend culon, $thatName")
  }

  def getMovies() = Action { implicit request: Request[AnyContent] =>
    val goodMovies: Seq[Movie] = MovieRepo.getMovies()
    val json: JsValue = Json.toJson(goodMovies)
    Ok(json)
  }

  def createMovies() = Action { implicit request: Request[AnyContent] =>
    val optJsonBody: Option[JsValue] = request.body.asJson
    val movie : JsResult[Movie]= optJsonBody.get.validate[Movie]
    movie match {
      case JsSuccess(movie, path) => {
        println(s"$movie")
        val json = Json.toJson(movie)
        Created(json)
      }
      case JsError(errors) => {
        println(s"Someone is sending bad stuff")
        val errorMsg  = errors.map(_._2).mkString(",")
        //val jsonError = Json.toJson(Error(errors.head._2.head.messages.mkString("")))
        val jsonError = Json.toJson(Error(errorMsg))
        BadRequest(jsonError)
      }
    }
  }



}
