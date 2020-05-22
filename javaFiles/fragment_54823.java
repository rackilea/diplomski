void createSession(String Username) {
        getThreadLocalRequest().getSession().setAttribute("Username", Username);
    }

    boolean validateSession(String Username) {
        if (getThreadLocalRequest().getSession().getAttribute("Username") != null) {
            return true;
        } else {
            return false;
        }
    }