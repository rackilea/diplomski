class Controller{
    @FXML
    Pane aPane;
    int globalValue;

    public Controller(int globalValue) {
        this.globalValue = globalValue ;
    }

    public Controller() {
        this(0);
    }

    public void setSomething(int value){
        globalValue = value;
        aPane.someMethod(globalValue)
    }

    @FXML
    void initialize(){
        aPane.someMethod(globalValue) //guaranteed not null at this point
    }


}