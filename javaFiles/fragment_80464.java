protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String parameter = request.getParameter("parameter");

    if (parameter.equals("hello")) {
        Object_DTO = new Object_DTO();
        ...
    }
}