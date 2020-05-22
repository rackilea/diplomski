try{
        BufferedReader br = new BufferedReader(new FileReader("C:\\TEMP\\MINUTE.txt"));

        String   line;
        String[] lineFields;
        int      i;
        int      thisLine_minute;
        int      lastLine_minute;
        Double   thisLine_reqpersec;
        Double   lastLine_reqpersec;
        lastLine_minute   = 0;
        thisLine_reqpersec= 0.0;
        lastLine_reqpersec= 0.0;
        while ( (line = br.readLine()) != null) {

            lineFields = line.split("\\s+");
            System.out.printf("LINE READ: %s\n", line);
            for (i=0; i < lineFields.length; i++) {
                System.out.printf("FIELD: %d  IS: %s\n", i, lineFields[i]);
            }
            if (lineFields[0].toUpperCase().equals("MINUTE")) {
                thisLine_minute=1;
            }
            else {
                thisLine_minute=0;
            }
            try {
            if (lastLine_minute==1) {
                lastLine_reqpersec = thisLine_reqpersec;
                thisLine_reqpersec = new Double(lineFields[4]);
            }
            }
            catch (Exception excepStrToInt) {
                thisLine_reqpersec = 0.0;
            }
            System.out.printf("*** REQUESTS PER SECOND: %f\n", 
            thisLine_reqpersec);
            System.out.printf("*** REQUESTS PER SECOND: DIFFERENCE: %f\n", 
            (thisLine_reqpersec- lastLine_reqpersec));

            lastLine_minute=thisLine_minute;
        }
        br.close();
    }
    catch(Exception e){
    }