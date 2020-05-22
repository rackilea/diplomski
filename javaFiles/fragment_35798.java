if ((boolean)session.getAttribute("usertype") == true) {
            int userID = Integer.parseInt(request.getParameter("id"));
            UserDAO dao = new UserDAO();
            User user = dao.ReturnUserID(userID);
            dao.DeleteUser(user);
            dao.Close();

            response.sendRedirect("/SupTracking/admin");******Called Here**********
        }
        response.sendRedirect("/SupTracking/index");*******Also Called Here**********