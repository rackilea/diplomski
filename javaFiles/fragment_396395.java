try {
        Workbook workbook;
        workbook = new XSSFWorkbook(OPCPackage.open(GlobalVariables.XLSM));
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(recordcount + 5);
        Cell cell;

        cell = row.createCell(GlobalVariables.testID);
        cell.setCellValue(recordcount);

        FileOutputStream out = new FileOutputStream(new File(File));
        // 1. write the workbook
        workbook.write(out);
        // 2. force the FileOutputStream to write everything out before closing it
        out.flush();
        // 3. then close the FileOutputStream
        out.close();
        // 4. finally close the workbook
        workbook.close();
        System.out.println("Data was written in XLSM");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (InvalidFormatException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }