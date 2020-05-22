try{
    String[] command = {"cmd", "/c", getMySuperAwesomeString()};
    Runtime.getRuntime().exec(command);
}catch(IOExecption ioe){
    System.err.println("I'm borken");
}