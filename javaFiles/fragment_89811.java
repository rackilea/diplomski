Element ref= doc.createElement("ref");
    while( (strLine = br.readLine()) != null) {                       
        if (strLine.equals(""))
            continue;
        int dotIndex = strLine.indexOf(".");
        num = strLine.substring(0,dotIndex);
        mix = strLine.substring(dotIndex+2,strLine.length());
        if(refStart(strLine)) {
            ref= doc.createElement("ref");
            reflist.appendChild(ref);
        }
        //now decide how to parse the input - maybe it will be different depending on 
        //whether the line we just read starts a new record or continues one from
        //the previous line.
    }


    public boolean refStart(String line) {
        if(line.length()<2) 
            return false;
        int dotIndex = strLine.indexOf(".");
        if(dotIndex<=0 || dotIndex>5) //assuming largest value is 99999
            return false;
        String numString = strLine.substring(0,dotIndex);
        for(int i=0; i<numString.length(); i++) {
            if(!Character.isDigit(numString.charAt(i) )
               return false;
        }
        return true;
    }