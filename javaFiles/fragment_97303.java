private static final String REQUEST_FILENAME = "RqstFile.txt";
private static final String RESPONSE_FILENAME = "RespFile.txt";

private File requestFile = null;
private File responseFile = null; 

void prepareFiles(String configuredPath)
{
    requestFile = new File(configuredPath, REQUEST_FILENAME);
    responseFile = new File(configuredPath, RESPONSE_FILENAME);
}

public File getRequestFile() { return requestFile; }
public File getResponseFile() { return responseFile; }