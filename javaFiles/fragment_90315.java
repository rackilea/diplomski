//br is the bufferedreader
    String line=null;
        boolean outputflag=false;
        while((line=br.readLine())!=null){
        if(line.contains("Outputs")) {

        outputflag=true;
//if you do not want the word Outputs in the output file just add 7 to start index
line=line.substring(line.indexOf("Outputs"),line.length());
//write line to outputs file
        }

        if(outputflag) {
        //write line to ouputfile
        }
        }