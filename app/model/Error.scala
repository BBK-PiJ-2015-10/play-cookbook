package model

import play.api.libs.json.{JsValue, Json, Writes}

case class Error(message: String)

object Error {
  implicit val movieWrites = new Writes[Error] {
    override def writes(o: Error): JsValue = Json.obj(
      "message" -> o.message,
    )
  }

}


