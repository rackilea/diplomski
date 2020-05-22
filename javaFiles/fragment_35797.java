protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("username") != null) {
        if ((boolean)session.getAttribute("usertype") == true) {
            int userID = Integer.parseInt(request.getParameter("id"));
            UserDAO dao = new UserDAO();
            User user = dao.ReturnUserID(userID);
            dao.DeleteUser(user);
            dao.Close();

            response.sendRedirect("/SupTracking/admin");
        }
        else
        {
            response.sendRedirect("/SupTracking/index");
        }
    }
    else
    {
        response.sendRedirect("/SupTracking/index");
    }
}