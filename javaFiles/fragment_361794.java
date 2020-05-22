ExternalContext ec=FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest req=(HttpServletRequest) ec.getRequest();
        HttpSession sess=(HttpSession) ec.getSession(true);
        String url = req.getRequestURL().append(";jsessionid=").append(sess.getId()).toString();

        ec.setRequest("http://localhost:8080/dir/dir/index.xhtml");
        HttpServletRequest req2=(HttpServletRequest) ec.getRequest();
        String url2 = req2.getRequestURL().append(";jsessionid=").append(sess.getId()).toString();
        Document doc2=Jsoup.connect(url2).get();
        System.out.println(doc2.html());