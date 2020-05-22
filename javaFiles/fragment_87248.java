try {
            String excelFilePath = "C:\\Users\\A7369241\\Desktop\\Temp.xlsx";
            ExcelWriter excelWriter = new ExcelWriter();
            List<Book> listBook = excelWriter.getListBook();
            excelWriter.writeExcel(listBook, excelFilePath);
            System.out.println("Excel file written successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }