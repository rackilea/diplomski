public void writeInstantText(BufferedWriter logWriter, String logTXT ){
  try
    {
        logWriter.write(logTXT + "\n");
        logWriter.flush();
    } catch(Exception e)
    {
        e.printStackTrace();
    }
}