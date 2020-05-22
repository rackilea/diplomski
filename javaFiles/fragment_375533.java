doFilter(request, response, chain)
{
  BufferedResponse bufferedResponse = new BufferedResponse(response);
  try
  {
     // pass control to the next filter or to the JSP/servlet servicing the request
     chain.doFilter(request, bufferedResponse);
  }
  finally
  {
     bufferedResponse.flush();
  }
}