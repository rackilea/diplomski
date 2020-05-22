context.setWelcomeFiles(new String[] { "index.html", "index.htm", "index.jsp" });

    // Lastly, the default servlet for root content (always needed, to satisfy servlet spec)
    // It is important that this is last.
    ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
    holderPwd.setInitParameter("resourceBase",pwdPath);
    holderPwd.setInitParameter("dirAllowed","true");
    context.addServlet(holderPwd,"/");