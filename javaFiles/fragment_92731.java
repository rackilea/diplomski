protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 PrintWriter out = response.getWriter();
 try {
    /* Execution of jSON Chart */
    Analytics show = new Analytics();
    List<JSONObject> json =  show.getStatisticPesanan();       
          out.print(js.toJSONString());
 } finally {
    out.close();
 }
}