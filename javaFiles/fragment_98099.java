public class AppStart {
  public static void main(String[] args) throws FileNotFoundException, IOException {

    VehicleManager vehicleManager = new VehicleManager();
    ObjectMapper objectMapper = new ObjectMapper();
    try{
    objectMapper.readerFor(VehicleManager.class).readValue(new File("yourJsonFilePath"));
    }
    catch(IOException ie){
      // log an IOException or do some other operation like rethrow, etc.,
    }
    catch(Exception e){
      // log exception
    }

}
}