@(user: Form[User])

@import helper._
@import helper.twitterBootstrap._

@main("Test") {

<H1>SHOW USER</H1>


@newUserView(user)

@documentView(user("user.document"))

}