public static boolean contentsAreIdentical(OdfSpreadsheetDocument document1, OdfSpreadsheetDocument document2) {  
    try {  
        ByteArrayInputStream bis1 = (ByteArrayInputStream) document1.getContentStream();  
        ByteArrayInputStream bis2 = (ByteArrayInputStream) document2.getContentStream();  

        if(bis1.available() != bis2.available()) {  
            return false;  
        }  

        while(true){  
            int a = bis1.read();  
                            int b = bis2.read();  
                            if(a != b){  
                                    return false;  
                            }  
                            if(a == -1){  
                                    return true;  
                            }  
                  }  
    } catch (Exception e) {  
        //Do something with exception  
    }  
    return false;  
}