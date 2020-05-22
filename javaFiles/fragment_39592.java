if ((request.getUserPrincipal().getName()) != null) {
            String userName = request.getUserPrincipal().getName().trim();
            session.setAttribute("userName", userName);
            .....
            if (request.isUserInRole("ADMINS")) {
              //do actions here
            }
        }