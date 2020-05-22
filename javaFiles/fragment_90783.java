//Read File Line By Line
while ((strLine = br.readLine()) != null) {
    System.out.println(strLine);
    String[] splitted=null;     

    //split the given line into array of words seperated by comma               
    splitted=strLine.split(",");

    for (int i=0; i < splitted.length; ++i ) {
        if (splitted[i].equals("."))
            break;

        //print each string one by one                                                    
        System.out.println(splitted[i]);
    }
}