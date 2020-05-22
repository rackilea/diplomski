@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");

        File xfile = < File>

        try (BufferedOutputStream bfos = new BufferedOutputStream(response.getOutputStream());
                FileInputStream fs = new FileInputStream(xfile)) {
            byte[] buffer = new byte[fis.available()];
            fs.read(buffer);

            bfos.write(buffer, 0, buffer.length);
            bfos.flush();
        }
 }