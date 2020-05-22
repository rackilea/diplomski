import javafx.application.Application;
    import javafx.beans.property.IntegerProperty;
    import javafx.beans.property.SimpleIntegerProperty;
    import javafx.beans.property.SimpleStringProperty;
    import javafx.beans.property.StringProperty;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.ComboBox;
    import javafx.scene.control.Label;
    import javafx.scene.control.ListCell;
    import javafx.scene.layout.HBox;
    import javafx.scene.layout.Priority;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    public class MultiLineComboBoxDemo extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            VBox root = new VBox();
            root.setSpacing(15);
            root.setPadding(new Insets(25));
            root.setAlignment(Pos.TOP_LEFT);
            Scene sc = new Scene(root, 600, 600);
            stage.setScene(sc);
            stage.show();

            final ObservableList<Person> items = FXCollections.observableArrayList();
            for (int i = 1; i < 4; i++) {
                items.add(new Person(i,"Name " + i, i + 30, "email" + i + "@test.com"));
            }

            final ComboBox<Person> comboBox = new ComboBox<>();
            comboBox.setItems(items);
            comboBox.setCellFactory(param -> new ListCell<Person>() {
                @Override
                protected void updateItem(Person item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        setGraphic(buildLayout(item));
                    } else {
                        setGraphic(null);
                    }
                }
            });
            comboBox.setButtonCell(new ListCell<Person>(){
                @Override
                protected void updateItem(Person item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        setGraphic(buildLayout(item));
                    } else {
                        setGraphic(null);
                    }
                }
            });
            comboBox.getSelectionModel().selectedItemProperty().addListener((obs,oldVal,selectedPerson)->{
                System.out.println("Name : "+selectedPerson.getName());
                // Do what you want..
            });
            root.getChildren().add(comboBox);
        }

        private HBox buildLayout(Person person) {
            VBox layout = new VBox();
            HBox.setHgrow(layout,Priority.ALWAYS);
            layout.setStyle("-fx-border-width:1px;-fx-border-color:#444444;");
            layout.setSpacing(5);
            layout.setPadding(new Insets(2));
            HBox topRow = new HBox();
            topRow.setSpacing(5);
            topRow.getChildren().addAll(getLabel("Name :","bold"),getLabel(person.getName(),"normal"), getLabel("Age :","bold"),getLabel(person.getAge()+"","normal"));
            HBox bottomRow = new HBox();
            bottomRow.setSpacing(5);
            bottomRow.getChildren().addAll(getLabel("Email :","bold"),getLabel(person.getEmail(),"normal"));
            layout.getChildren().addAll(topRow, bottomRow);

            HBox pane = new HBox();
            pane.setAlignment(Pos.CENTER_LEFT);
            pane.setSpacing(5);
            pane.setPadding(new Insets(2));
            Label num = new Label(person.getId()+"");
            num.setStyle("-fx-font-size:20px;-fx-font-weight:bold;-fx-text-fill:black;");
            pane.getChildren().addAll(num,layout);
            return pane;
        }

    private Label getLabel(String txt, String style){
        Label lblName = new Label(txt);
        lblName.setStyle("-fx-font-weight:"+style+";-fx-text-fill:black;");
        return lblName;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    class Person {
        IntegerProperty id = new SimpleIntegerProperty();
        StringProperty name = new SimpleStringProperty();
        IntegerProperty age = new SimpleIntegerProperty();
        StringProperty email = new SimpleStringProperty();

        public Person(int id,String name, int age, String email) {
            setId(id);
            setName(name);
            setAge(age);
            setEmail(email);
        }

        public int getId() {
            return id.get();
        }

        public IntegerProperty idProperty() {
            return id;
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public int getAge() {
            return age.get();
        }

        public IntegerProperty ageProperty() {
            return age;
        }

        public void setAge(int age) {
            this.age.set(age);
        }

        public String getEmail() {
            return email.get();
        }

        public StringProperty emailProperty() {
            return email;
        }

        public void setEmail(String email) {
            this.email.set(email);
        }
    }
}