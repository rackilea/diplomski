private void batch(String commands){
  try{
    String filename = "Temp.bat";
    File f = new File(filename);
    PrintWriter writer = new PrintWriter(f);
    writer.print(commands);
    writer.close();
    Runtime.getRuntime().exec(filename);

    long x = getTime + 3000;
    do{
      //Wait
    }while(getTime < x);

    f.delete();
  }catch(Exception ex){
    ex.printStackTrace();
  }
}

private long getTime(){
  SimpleDateFormat datef = new SimpleDateFormat("yyyyDDDHHmmssSSS");
  Date date = new Date();
  return Long.parseLong("" + datef.format(date));
}