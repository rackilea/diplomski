import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ListViewApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ListView<Animal> listview = new ListView<>(FXCollections.observableArrayList(new Dog(1, "John"), new Cat(2, "Fluffy")));
        listview.setCellFactory(param -> new ListCell<Animal>() {

            @Override
            protected void updateItem(Animal animal, boolean empty) {
                super.updateItem(animal, empty);
                if (animal != null) {
                    setText(animal.getText());
                }
            }
        });

        stage.setScene(new Scene(listview));
        stage.show();
    }
}

class Animal {
    protected final int id;

    public Animal(int id) {
        this.id = id;
    }

    protected String getText() {
        return "";
    }
}

class Dog extends Animal {
    private final String owner;

    public Dog(int id, String owner) {
        super(id);
        this.owner = owner;
    }

    @Override
    protected String getText() {
        return "DOG id=" + id + ", owner=" + owner;
    }
}

class Cat extends Animal {
    private final String name;

    public Cat(int id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    protected String getText() {
        return "CAT id=" + id + ", name=" + name;
    }
}