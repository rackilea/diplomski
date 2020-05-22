public void start() { 
    try { 
        xPresentation.setPropertyValue("Display", 1); 
    } 
    catch (Exception ex) { 
        ex.printStackTrace(); 
    } 
    xPresentation.start(); 
}