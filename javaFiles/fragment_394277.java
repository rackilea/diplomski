static void writeToFile(Map<String,String> map, String pathToFile)
{                                 
  Iterator<Map.Entry<String,String>> itr = map.entrySet().iterator();
  File path = new File(pathToFile);
  while(itr.hasNext())    {
    Map.Entry<String,String> pairs = (Map.Entry<String,String>)itr.next();
    FileUtils.writeStringToFile(path,
      pairs.getKey() + "=" + pairs.getValue(), 
      true);// append rather than overwrite
  }
}