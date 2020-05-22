private static Properties prop = new Properties();
private static String filename = "<name of file>.properties";
InputStream input = <ClassName>.class.getClassLoader().getResourceAsStream(filename);
try {

    if (input==null) {
        loggerOut.log(Level.SEVERE, "Sorry, unable to find " + filename);
    }
    prop.load(input);   
    loggerOut.info("XML In storage path: " prop.getProperty("<property in file>"));
    fileNameAndPath = prop.getProperty("fileNameAndPathIN").trim();
    logNameAndPath = logPath + logName;

} catch (IOException ex) {
    ex.printStackTrace();
} finally {
    if (input!=null) {
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}