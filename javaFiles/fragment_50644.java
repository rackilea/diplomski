public static void downloadFile() throws IOException {
    try {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Connection conn = JdbcUtil.getConnection(facesContext, "derby1");
        ResultSet rs = conn.createStatement().executeQuery(
                            "SELECT files FROM test_goverment where who='d'");
        byte[] imgBytes = null;
        if (rs != null) {
            while (rs.next()) {
                imgBytes = rs.getBytes(1);
            }
            ExternalContext extCon = facesContext.getExternalContext();
            XspHttpServletResponse response = (XspHttpServletResponse)extCon.getResponse();
            response.reset();
            response.setContentType("text/plain");
            response.setHeader("Content-disposition", "attachment; filename=output.txt");
            response.setHeader("Cache-Control", "no-cache");
            OutputStream os = response.getOutputStream();
            os.write(imgBytes);
            os.flush();
            facesContext.responseComplete();
            rs.close();              
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}