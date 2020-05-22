String token = request.getParameter("token");
Set<String> tokens = (Set<String>) request.getSession().getAttribute("tokens");

if (!tokens.remove(token)) {
    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    return;
}

// ...