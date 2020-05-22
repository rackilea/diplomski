protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException {

        resp.setContentType("text/csv");
        resp.setHeader("Content-disposition", "attachment; filename=TCRKBOS_050020_" + mTodayDate + ".csv");

        try (OutputStream out = resp.getOutputStream()) {
            //todo: write the CSV data to the output stream
        }
    }