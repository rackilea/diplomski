import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.sun.javafx.collections.VetoableListDecorator;

public class CustomObservableList<E> extends VetoableListDecorator<E> {

    public CustomObservableList(ObservableList<E> decorated) {
        super(decorated);
    }

    @Override
    protected void onProposedChange(List<E> toBeAdded, int... indexes) {
        for (E e : toBeAdded) {
            if (contains(e)) {
                throw new IllegalArgumentException("Duplicament element added");
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Set<Object> set = new HashSet<Object>();
        set.add(o1);
        CustomObservableList<Object> list = new CustomObservableList<Object>(FXCollections.observableArrayList(set));
        list.add(o2);
        list.add(o1); // throw Exception
    }
}