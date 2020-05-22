protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    System.out.println("CAHttpsServlet: checking request is secure");
    if(request.isSecure() == false){
        System.out.println("CAHttpsServlet: Request is NOT secure. Sending 400");
        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
}