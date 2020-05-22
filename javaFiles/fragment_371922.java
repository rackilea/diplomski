public void dumpWorkbookToAFile(XSSFWorkbook wb, String filename) {
    try {
        FileOutputStream fos = new FileOutputStream(filename);
        wb.write(fos);
        fos.close();
        MessageDialog.openInformation(shell,
            "Save Workbook Successful",
            "Workbook saved to the file:\n\n" + filename);
    } catch (IOException ioe) {
        ioe.printStackTrace();
        String msg = ioe.getMessage();
        MessageDialog.openError(shell, 
            "Save Workbook Failed",
            "Could not save workbook to the file:\n\n" + msg);
    }
}