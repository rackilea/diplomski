val userPostWithErrors = Action(parse.form(userForm, onErrors = (formWithErrors: Form[UserData]) => {
  implicit val messages = messagesApi.preferred(Seq(Lang.defaultLang))
  BadRequest(views.html.user(formWithErrors))
})) { implicit request =>
  val userData = request.body
  val newUser = models.User(userData.name, userData.age)
  val id = models.User.create(newUser)
  Redirect(routes.Application.home(id))
}