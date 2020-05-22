public class Proyect extends Application implements EventHandler{

private Button btnR;

private HBox menu1() {
    Image food1 = new Image (getClass().getResourceAsStream("clipboard.png"));
    btnR = new Button ("R", new ImageView(food1));
}

@Override
public void handle(Event event) {
    if(event.getSource() == btnR) {

    }
}
}