doGet(HttpServletRequest req, HttpServletResponse resp) {
  User user = getLoggedInUser(req);
  StaticClass.getThreadLocal().set(user)
  try {
    doSomething()
    doSomethingElse()
    renderResponse(resp)
  }
  finally {
    StaticClass.getThreadLocal().remove()
  }
}