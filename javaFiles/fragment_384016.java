while(fileScan.hasNextLine()){

    //save the line
    String line = fileScan.nextLine();

    //if line is NOT empty AND starts with Q do something
    if(!line.isEmpty() && line.charAt(0) == 'Q'){
        System.out.println(line);
    }

}