catch (SQLException e) {
    // TODO: log the exception
    // this is our fault, let the user know we failed
    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    return;
}