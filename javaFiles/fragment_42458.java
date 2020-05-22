File file = new File("Report" + new Date().getTime() + ".xlsx");

        System.out.println(file.getAbsolutePath());
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();