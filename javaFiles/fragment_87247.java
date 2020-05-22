public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ExcelWriter excelWriter = new ExcelWriter();
            List<Book> listBook = excelWriter.getListBook();
            excelWriter.writeExcel(listBook, excelFilePath);
            System.out.println("Excel file written successfully");

            String excelFilePath = "C:\\Users\\A7369241\\Desktop\\Temp.xls";
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=temp.xls");

            OutputStream out = response.getOutputStream();
            try (FileInputStream in = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
            out.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }