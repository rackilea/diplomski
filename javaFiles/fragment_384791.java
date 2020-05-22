import javafx.collections.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("s1");
        list.add("s2");

        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> change) {
                while (change.next()) {
                    System.out.println("added: " + change.getAddedSubList());
                }
            }
        });

        observableList.add("s3");
    }
}