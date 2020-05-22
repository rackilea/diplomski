protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Note that unless except in certain cases (IoC)
    // this scenario is quite easy to avoid
    Object_DTO object_DTO = null;

    if(request.getParameter("parameter").equals("hello")) {
        object_DTO = new Object_DTO();
        object_DTO.setAttr("attr");
        ...
    } else if (request.getParameter("parameter").equals("goodbye")) {
        object_DTO = new Object_DTO();
    }

    if (object_DTO == null) {
        // Bad response
    }
}