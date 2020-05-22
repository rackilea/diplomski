class DataRetriever{
private DataParser dataParser;

public DataRetriever(){
    dataParser = new JsonDataParser(); //tomorrow this can be changed to something else
}

public DataObject getData(String data){
      // Get data from server using URL 
      return dataParser.parseData(data);
   }
}