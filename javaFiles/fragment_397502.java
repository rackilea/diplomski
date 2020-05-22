while(scnr.hasNextLine()){
    String temp = scnr.nextLine(); //Cache variable
    if (temp.startsWith(newName)){ //Check if it matches
        System.out.println(temp); //Print if match
    }
}