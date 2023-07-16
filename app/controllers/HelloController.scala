package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HelloController  @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def sayHello() = Action { implicit request: Request[AnyContent] =>
    Ok("Hello, friend")
  }

  def sayHi(thatName: String) = Action { implicit request: Request[AnyContent] =>
    Ok(s"Hi my friend culon, $thatName")
  }
}
