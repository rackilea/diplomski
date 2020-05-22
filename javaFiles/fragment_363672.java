public class DrawImageController{

    @FXML ImageView war;

    @FXML
    public void press123(KeyEvent event){

        System.out.println("Key Pressed"); // print a message
        if(event.getCode()==KeyCode.ENTER) {war.relocate (50,50); }
    }
}