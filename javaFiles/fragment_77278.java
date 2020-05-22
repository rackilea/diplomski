while(sc.hasNextLine()){
    String g = sc.nextLine();
    if(g.indexOf('.')!= -1){//check if the line contains a '.' character
        count += g.split("\\.").length; // split the line into an array of Strings using '.' as a delimiter
    }
}