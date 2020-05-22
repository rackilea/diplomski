public class ListClass {
 public List list;
 ListClass(){
   try{
        CSVReader csvReader = new CSVReader();
        list = csvReader.Read("csvFile.csv");
       }catch(IOException e){
         //handle the exception
       }
   }
}