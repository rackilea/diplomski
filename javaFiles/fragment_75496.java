protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  DataSource datas = (DataSource) getServletContext().getAttribute("ds");

  try (Connection conn = datas.getConnection();Statement stmt = conn.createStatement()){


    //some sql
    //process form
    //pass the return values

  } catch (Exception e) {
    e.printStackTrace();
  }
}