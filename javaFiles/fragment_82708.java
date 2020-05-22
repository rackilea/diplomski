public void saveNumberIntoFile(String fileNumber) throws IOException {
    try {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.name("")));
        BufferedWriter writer = new BufferedWriter(
        new FileWriter("C:\\Users\\xxx\\Documents\\samplefile.txt", true) //Set true for append mode
        );
        writer.newLine(); //Add new line
        writer.write(fileNumber);

        writer.close();
    } catch (NoSuchElementException e) {
        // TODO: handle exception
    }
}