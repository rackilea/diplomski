@defining(Users.all()) { users =>
  @if (users.isEmpty) {
    // Show the alert.
  }
  @for(user <- users) {
    …
  }
}