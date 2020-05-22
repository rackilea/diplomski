package controllers

import javax.inject._

import play.api._
import play.api.i18n._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, testView: views.html.test) (implicit configuration: Configuration) extends AbstractController(cc) with I18nSupport{

  def test() = Action  { implicit request =>
    Ok(testView("play.i18n.langs"))
  }
}