public void doPost( // or doGet
    HttpServletRequest req, 
    HttpServletResponse res
) throws ServletException, IOException  {
    List<Object> myList = new ArrayList<>();
    JSONArray jsonArray = new JSONArray(myList);
    res.setContentType("application/json");
    res.getWriter().print(jsonArray);
    res.getWriter().flush();
    res.getWriter().close();
    res.flushBuffer();
}