public static void main(String[] args){
    //if log to file arg = true
        DOMConfigurator.configure("logToFile.log4j.xml");
    //else
        DOMConfigurator.configure("logToConsoleOnly.log4j.xml");
}