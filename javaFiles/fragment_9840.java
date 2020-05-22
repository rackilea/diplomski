try {
     HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        String backurl = request.getHeader("referer");
        System.out.println(" Backurl : " + backurl);
        Map session = ActionContext.getContext().getSession();
        if (session.get("cus") != null) {
            return "already_login";
        } else {

            return "not_yet_login";
        }

    } catch (Exception e) {
        logger.info("Error : " + e);
        logger.info("Error Message : " + e.getMessage());

    }