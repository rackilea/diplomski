//Record to log
try{
    writer.write("test log message");
    writer.close();
}catch(Exception e){
    System.err.println("could not write to log");
    e.printStackTrace();
}