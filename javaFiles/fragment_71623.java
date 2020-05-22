public class ComboController implements Initializable {
        // @FXML elements here

       @Override
       public void initialize(URL arg0, ResourceBundle arg1) {
             detectPort(); // Include all the code that you need for initializing elements here
       }

      // port detector method
      // Dummy method - Include arduino calls here
      private void detectPort(){

           System.out.println("\n1/3 Now detecting port...");

           portList = FXCollections.observableArrayList();

           String[] serialPortNames = {"COM1", "COM2", "COM3"}; //    SerialPortList.getPortNames();

           for(String name: serialPortNames){
               System.out.println("\nDetected Port: ");
               System.out.println(name);
               portList.add(name);
           }

           // No need to create a new combo instance
           // No need to add a change listener to refresh ports
           comboBoxPorts.setItems(portList); 
       }

       // Arduino methods here
  }