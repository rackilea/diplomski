@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // ...
    String jsonString = gson.toJson(new Tuple(key, value)).toString();

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(jsonString);
}