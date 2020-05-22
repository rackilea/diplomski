public static HSSFWorkbook loadWorkbook(String fileName)throws CustomException{
    try{
        SmbFileInputStream fin = new SmbFileInputStream(...);
        //do stuff with fin
        return wb;
    } catch(FileNotFoundException f) {
        //handle file not found
        throw new CustomException("File Not found ...", f);
    } catch(IOException io) {
        //handle io exception
        throw new CustomException("loadWorkBook failed", io);
    }
}