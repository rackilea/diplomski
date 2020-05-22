doGet(HttpServletRequest req, HttpServletResponse resp) {
  User user = getLoggedInUser(req);
  doSomething(user)
  doSomethingElse(user)
  renderResponse(resp,user)
}