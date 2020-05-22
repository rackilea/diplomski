@Override
public synchronized void onTestFailure(ITestResult tr){
    try {
        Workbook workbook = Workbook.getWorkbook(new File(testData), workbookSettings);
        WritableWorkbook wb = Workbook.createWorkbook(new File(testData), workbook);
        WritableSheet ws = wb.getSheet("OrderEditQA3");
        Label label = new Label(5,2, "Fail");
        ws.addCell(label);
        wb.write();
        wb.close();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (BiffException b){
        System.out.print("Error!");
    } catch (WriteException we){
        System.out.print("");
    }
}