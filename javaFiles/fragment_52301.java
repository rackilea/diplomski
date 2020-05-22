doGet(HttpServletRequest req, HttpServletResponse resp) {
  User user = getLoggedInUser(req);
  doSomething()
  doSomethingElse()
  renderResponse(resp)
}