try {
        HttpServletRequest request = (HttpServletRequest) javax.security.jacc.PolicyContext
                .getContext(HttpServletRequest.class.getName());
    } catch (PolicyContextException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }