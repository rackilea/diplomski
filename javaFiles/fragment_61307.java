public class MainController implements Initializable {

    int z1=0,y2=0,x=0; 

    @FXML
    GridPane gp;

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        while(z1<4){    //add 4 buttons
            addButton();
            z1++;
        }   
    }   

    private void addButton() {
        // TODO Auto-generated method stub
        final Button temp1=new Button("Button "+ y2);
        final int numberButton=y2;
        temp1.setId(""+y2);
        temp1.setText("whatever u want!!");
        temp1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("id("+temp1.getId()+")="+numberButton);
            }
        });
        gp.add(temp1, x, 0);  //x is column index and 0 is row index
        x++;
    }
}