if(UserSession.isSessionValid()){
        System.out.println("ready to enter");
        return true;
    }else{
        System.out.println("not logged in...redirecting to login");
        response.sendRedirect("/in_development_page");
        return false;
    }