String login = request.getParameter("login");
String password = request.getParameter("password");
if(checkLogin(login, password))
{
    response.sendRedirect(SUCCESS_URL);
}
else
{
    response.sendRedirect(BAD_PASS);
}
// SUCCESS_URL and BAD_PASS are URLs for your redirect