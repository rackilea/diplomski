protected void doGet(HttpServletRequest aRequest, HttpServletResponse aResponse) 
    throws ServletException, IOException 
    {
        aResponse.setContentType("application/json");
        aResponse.setCharacterEncoding("UTF-8");
        QueryObject queryObject = new QueryObject();
        queryObject.setSearchText(aRequest.getParameter("searchText"));
        String[] types = aRequest.getParameterValues("types[]");
        queryObject.setTypes(types);
        queryObject.setResultNumber(Integer.parseInt(aRequest.getParameter("resultNumber")));

        JSONArray results = indexManager.doSearch(queryObject);

        aResponse.getWriter().write(results.toString());

        PrintWriter out = aResponse.getWriter();
        out.flush();
    }