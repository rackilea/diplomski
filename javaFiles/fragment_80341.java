import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class TreeTableExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<Object> treeTable = new TreeTableView<>();
        treeTable.setShowRoot(false);

        TreeTableColumn<Object, String> nameColumn = new TreeTableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && (rowItem.getValue() instanceof Factory)) {
                Factory f = (Factory) rowItem.getValue() ;
                return new SimpleStringProperty(f.getName());
            } else {
                return new SimpleStringProperty("");
            }
        });

        TreeTableColumn<Object, Number> sizeColumn = new TreeTableColumn<>("Size");
        sizeColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && (rowItem.getValue() instanceof Factory)) {
                Factory f = (Factory) rowItem.getValue() ;
                return new SimpleObjectProperty<Number>(Double.valueOf(f.getSize()));
            } else {
                return new SimpleObjectProperty<Number>(null);
            }
        });

        TreeTableColumn<Object, String> employeeColumn = new TreeTableColumn<>("Employee");
        employeeColumn.setCellValueFactory(cellData -> {
            TreeItem<Object> rowItem = cellData.getValue();
            if (rowItem != null && (rowItem.getValue() instanceof Employee)) {
                Employee emp = (Employee) rowItem.getValue() ;
                return new SimpleStringProperty(emp.getName());
            } else {
                return new SimpleStringProperty("");
            }
        });

        treeTable.getColumns().addAll(nameColumn, sizeColumn, employeeColumn);

        List<Factory> factories = createData();
        TreeItem<Object> root = new TreeItem<>(null);
        for (Factory factory : factories) {
            TreeItem<Object> factoryItem = new TreeItem<>(factory);
            root.getChildren().add(factoryItem);
            for (Employee emp : factory.getEmployees()) {
                TreeItem<Object> employeeItem = new TreeItem<>(emp);
                factoryItem.getChildren().add(employeeItem);
            }
        }
        treeTable.setRoot(root);

        Scene scene = new Scene(treeTable, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private List<Factory> createData() {
        String[][] empNames = {
                {"John", "Jane", "Mary"},
                {"Susan", "Mike"},
                {"Alex", "Francois", "Joanne"}
        };
        List<Factory> factories = new ArrayList<>();
        for (String[] emps : empNames) {
            int count = factories.size()+1 ;
            Factory f = new Factory("Factory "+ count, count*10);
            for (String empName : emps) {
                f.getEmployees().add(new Employee(empName));
            }
            factories.add(f);
        }
        return factories ;
    }

    public static class Employee {
        private String name ;

        public Employee(String name) {
            this.name = name ;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }

    public class Factory {
        private String name ;
        private double size ;
        private List<Employee> employees ;

        public Factory(String name, double size) {
            this.name = name ;
            this.size = size ;
            this.employees = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public List<Employee> getEmployees() {
            return employees;
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}