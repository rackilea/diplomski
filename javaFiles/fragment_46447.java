protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("doPost() invoked..");

    Boolean valueToChange = Boolean.valueOf(request.getParameter("valueToChange"));
    System.out.println("valueToChange:"+valueToChange);
    //Here, Do your works..
    response.getWriter().write("successfully changed.");        
}