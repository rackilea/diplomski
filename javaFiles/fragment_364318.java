public class Controller implements Initializable{
    public TableView<Student> fxClassroom;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      ....
    fxClassroom.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      ....
    }

        public void deleteStudent(){
            ObservableList<Student> studentSelected, allStudents;
            allStudents = fxClassroom.getItems();
            studentSelected = fxClassroom.getSelectionModel().getSelectedItems();
            allStudents.removeAll(studentSelected);


        }
    }