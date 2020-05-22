try {
    //do something
}catch(FileNotFoundException ex){
    System.err.print("ERROR: File containing _______ information not found:\n");
    ex.printStackTrace();
    System.exit(1);
}