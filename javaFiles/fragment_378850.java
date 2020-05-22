String callbackName = request.getParameter("callback");

// ... your JSON code 

if (callbackName != null)
{
    // JSONP wrapping:
    response.getWriter().write(callbackName +
                               "(" + stringWriter.toString() + ")");
    System.out.println(callbackName + "(" + stringWriter.toString() + ")");
}
else
{
    response.getWriter().write(stringWriter.toString());
    System.out.println(stringWriter.toString());
}

response.getWriter().close();