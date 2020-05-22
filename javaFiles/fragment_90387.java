public class Controller {

    @FXML
    private ScrollPane mainScrollPane;
    @FXML
    private Label dateScrollerLabel;
    @FXML
    private HBox calendarContainer;

    public void initialize() {
        System.out.println(x); // not null
        System.out.println(calendarContainer); // not null
        currentSchedule = new Schedule(mainScrollPane, dateScrollerLabel, calendarContainer); // no nullpointer exception
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case A:
                System.out.println(x); // not null
                System.out.println(calendarContainer); // null
                currentSchedule = new Schedule(mainScrollPane, dateScrollerLabel, calendarContainer); // nullpointer exception
                break;
        }
    }  

}