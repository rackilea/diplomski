int iD;
try {
    iD = Integer.parseInt(request.getParameter("iD"));
} catch (NumberFormatException e) {
    // Send back error message to the client, for example:
    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid iD!");
    return;
}