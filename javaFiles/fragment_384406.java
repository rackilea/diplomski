class MyHttpServletRequest implements HttpServletRequest
{
  //whatever
}

class MyHttpServletResponse implements HttpServletResponse
{
  //whatever
}


doGet(new MyHttpServletRequest(),
      new MyHttpServletResponse())