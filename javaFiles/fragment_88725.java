if (foo != null) { 
    processFoo(request, response, foo);
}
else {
    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
}