protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String title = "Welcome to My Store";

    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("rd");
    List<String> errors = new ArrayList<String>();

    response.setContentType("text/html");

    if (firstName.equals("") || null == firstName) {
        errors.add("First Name can't be empty.");
    }

    // Check the other fields the same way.

    if (!errors.isEmpty()) {
        // There are errors. Send the old HTML and for example add
        // a list with the error messages.
        String errorList = "<ul>";

        for (String error : errors) {
            errorList += "<li>" + error + "</li>";
        }

        errorList += "</ul>";

        // Insert errorList to the other HTML.
    } else {
        // No errors! Send the new HTML.
    }
}