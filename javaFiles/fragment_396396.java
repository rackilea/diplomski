public class PoiMain {

    public static void main(String[] args) {
        /*
         * Setup:
         * An existing xlsx file with a first sheet containing 6 columns and 1 row.
         * The row has 6 filled cells with the values
         * cell 1 (index 0): There
         * cell 2 (index 1): is
         * cell 3 (index 2): a
         * cell 4 (index 3): house
         * cell 5 (index 4): in
         * cell 6 (index 5): New Orleans
         * 
         * Task:
         * Write the words "they", "call", "it", "the", "rising", "sun"
         * in the cells below.
         */

        // define the (correct) path to the workbook
        String pathToFile = "Y:\\our\\path\\to\\the\\Test-Workbook.xlsx"; // you can use an xlsm here, too
        // create a Path object
        Path filePath = Paths.get(pathToFile);
        // declare a workbook
        XSSFWorkbook workbook;

        try {
            /*
             * READING from the .xlsx file:
             */

            FileInputStream in = new FileInputStream(filePath.toFile());
            workbook = XSSFWorkbookFactory.createWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // read all the cells of the first row and print their content
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    XSSFCell cell = row.getCell(j);
                    System.out.println(cell.getStringCellValue());
                }
            }

            /*
             * WRITING to the .xlsx file already read
             */

            // create some meaningful words to be added to some cells in the workbook
            List<String> wordsToBeWritten = Arrays.asList("they", "call", "it", "the", "rising", "sun");

            FileOutputStream out = new FileOutputStream(filePath.toAbsolutePath().toString());
            sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows());
            // create new cells and write the words into them
            for (int i = 0; i < wordsToBeWritten.size(); i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(wordsToBeWritten.get(i));
            }
            // close the FileInputStream
            in.close();
            // write the workbook using the FileOutputStream
            workbook.write(out);
            // force the FileOutputStream to write everything until it is empty
            out.flush();
            // close the FileOutputStream
            out.close();
            // close the workbook.
            workbook.close();
        } catch (FileNotFoundException e) {
            System.err.println(
                    "The file \"" + filePath.toAbsolutePath().toString() + "\" could not be found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error while reading the file \"" + filePath.toAbsolutePath().toString() + "\"");
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            System.out.println(
                    "The file \"" + filePath.toAbsolutePath().toString() + "\" has an invalid format(ting)");
            e.printStackTrace();
        } catch (EmptyFileException e) {
            System.err.println("The supplied file \"" + filePath.toAbsolutePath().toString() + "\" is empty.");
            e.printStackTrace();
        }
}