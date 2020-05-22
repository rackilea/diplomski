public void runTests(){
    if(testsRunning) return;

    testsRunning = true;

    final Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            FileInputStream fis = null;
            File testDataFile = null;
            try {
                fis = new FileInputStream(selectedTestDataFile);
            } catch (FileNotFoundException e) {
                displayResponse("File Input Stream Error: File Not Found");
            }

            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = null;
            try {
                myWorkBook = new XSSFWorkbook(fis);
            } catch (IOException e) {
                displayResponse("XSSFWorkbook I/O Error");
            }

            // displayResponse(first sheet from the XLSX workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            int totalWids = mySheet.getLastRowNum();

            for (int rowIndex = 1; rowIndex <= totalWids; rowIndex++) {
                updateProgress(rowIndex, totalWids);
                Row row = mySheet.getRow(rowIndex);
                if (row != null) {
                    String data = "");

                    Cell cellData = row.getCell(2);

                    if (cellData != null) {
                        data = cellWid.getStringCellValue();
                        boolean testresult = runTest(data);
                        System.out.println(rowIndex + ". data = " + data + ", testresult = " + testresult);
                    }
                }
            }

            /* xlsx read */
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(selectedTestDataFile);
            } catch (FileNotFoundException e) {
                try {
                    myWorkBook.close();
                } catch (IOException e1) {
                    displayResponse("Error: Please Close Workbook");
                }
                displayResponse("Error: File Not Found");
            }
            try {
                myWorkBook.write(fos);
            } catch (IOException e) {
                try {
                    myWorkBook.close();
                } catch (IOException e1) {
                    displayResponse("Error: Please Close Workbook");
                }
                displayResponse("Error: Workbook Write");
            }
            try {
                fos.close();
            } catch (IOException e) {
                try {
                    myWorkBook.close();
                } catch (IOException e1) {
                    displayResponse("Error: Please Close Workbook");
                }
                displayResponse("Error: File Output Stream");
            }
            try {
                myWorkBook.close();
            } catch (IOException e) {
                displayResponse("Error: Please Close Workbook");
            }
            try {
                fis.close();
            } catch (IOException e) {
                displayResponse("Error: Input file format");
            }

            displayResponse("Testing Complete!");

            return null;
        }
        private void displayResponse(String testResultMessage){
            Platform.runLater(()->{
                if (testResultMessage.equals("Testing Complete!")) {
                    Alert alert = DialogUtils.getAlert("Info", "Information", testResultMessage, "info");
                    alert.showAndWait();

                } else {
                    Alert alert = DialogUtils.getAlert("Error", "Error(s)", testResultMessage, "error");
                    alert.showAndWait();
                }
                testsRunning = false;
            });
        }
    };

    progressBar.progressProperty().bind(task.progressProperty());
    progressIndicator.progressProperty().bind(task.progressProperty());

    final Thread thread = new Thread(task, "task-thread");
    thread.setDaemon(true);
    thread.start();
}