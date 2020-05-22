@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String, String> options = new LinkedHashMap<>();
    options.put("value1", "label1");
    options.put("value2", "label2");
    options.put("value3", "label3");
    String json = new Gson().toJson(options);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
}