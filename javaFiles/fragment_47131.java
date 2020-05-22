@ResponseBody
@ExceptionHandler(LoginIsBusyException.class)
public String handleException(HttpServletResponse response) throws IOException 
{
   response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Login is busy");
}