public class MainController {
/**
 * var name has to be topController
 */
public TopController topController;
/**
 * var name has to be bottomController
 */
public BottomController bottomController;

public void initialize(){
    Button topbtn=topController.topbtn;
    Button bottombtn=bottomController.bottombtn;
    topbtn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Hello from top button");
            topbtn.setDisable(true); //OK!
            bottombtn.setDisable(false); //Failed
        }
    });

}
}