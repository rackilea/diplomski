public abstract class ReaderUtil<K, V> {

 protected abstract Map<K, V> newMap(); 
 protected abstract void doThings(String data, Map<K, V> resultMap);

 public Map<K, V> readAllLogsIntoMap(File file){
      if (!file.exists()){
          return newMap();
      }
      BufferedReader reader = null;
      FileReader fileReader = null;
      String data = null;
      Map <K, V> resultMap = newMap();
      try {
         fileReader = new FileReader(file);
         reader = new BufferedReader(fileReader);
         while ((data = reader.readLine()) != null){
             doThings(data, resultMap);
         }
     } catch(Exception e){

     }
     finally{
         try{
             if (reader != null) reader.close();
             if (fileReader != null) fileReader.close();
         } catch(IOException ioe){

         }
     }
     return resultMap;
 }
}