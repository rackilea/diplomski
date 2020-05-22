// in main
process(requestFile, responseFile, logFile);

// later
public static void process(String requestFile, String responseFile, String logFile) throw IOException {
    //Connect to the Request Input File 
    FileInputStream requestIn = new FileInputStream(requestFile);  
    //Connect to the Response Output File 
    FileOutputStream responseOut = new FileOutputStream(responseFile);
    //Connect to the Request/Response Log File 
    FileOutputStream logOut = new FileOutputStream(logFile);

    requestIn.close();
    responseOut.close();
    logOut.close();
}