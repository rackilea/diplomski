1. 

LineNumberReader lnr = new 
                  LineNumberReader(new FileReader(new File("C:/Testing.txt")));        
    if (str1.contains("A/C NO:")) {
        int num = lnr.getLineNumber();
        System.out.println(num+1);
    }




2.  OR you can use setLineNumber(int) as mentioned in java docs.