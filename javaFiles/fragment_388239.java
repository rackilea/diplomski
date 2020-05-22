import java.math.BigDecimal;
import java.math.MathContext;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class BigDecTable extends Application {
    private static final MathContext mc = new MathContext(5);

    @Override
    public void start(Stage primaryStage) {
        ObservableList<Data> data = FXCollections.observableArrayList(
                new Data(new BigDecimal(123.45,mc),new BigDecimal(123.45,mc)),
                new Data(new BigDecimal(123.45,mc),new BigDecimal(123.45,mc))
        );
        TableView tv = new TableView(data);
        tv.setEditable(true);
        tv.getSelectionModel().setCellSelectionEnabled(true);

        StringConverter bdsc = new StringConverter<BigDecimal>() {

            @Override
            public String toString(BigDecimal object) {
                return object.toPlainString();
            }

            @Override
            public BigDecimal fromString(String string) {
                if(string==null || string.isEmpty()) return BigDecimal.ZERO;
                return new BigDecimal(string,mc);
            }
        };

        TableColumn fld1Col = new TableColumn("fld1");
        fld1Col.setCellValueFactory(new PropertyValueFactory("fld1"));
        fld1Col.setCellFactory(TextFieldTableCell.forTableColumn(bdsc));

        TableColumn fld2Col = new TableColumn("fld2");
        fld2Col.setCellValueFactory(new PropertyValueFactory("fld2"));
        fld2Col.setCellFactory(TextFieldTableCell.forTableColumn(bdsc));

        TableColumn fld3Col = new TableColumn("tot");
        fld3Col.setCellValueFactory(new PropertyValueFactory("fld3"));
        fld3Col.setEditable(false);

        tv.getColumns().addAll(fld1Col,fld2Col,fld3Col);

        StackPane root = new StackPane();
        root.getChildren().add(tv);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Data{
        SimpleObjectProperty<BigDecimal> fld1;
        SimpleObjectProperty<BigDecimal> fld2;
        SimpleObjectProperty<BigDecimal> fld3;

        public SimpleObjectProperty<BigDecimal> fld1Property() {return fld1;}
        public SimpleObjectProperty<BigDecimal> fld2Property() {return fld2;}
        public SimpleObjectProperty<BigDecimal> fld3Property() {return fld3;}

        public Data(BigDecimal fld1val, BigDecimal fld2val) {
            this.fld1 = new SimpleObjectProperty<>(fld1val);
            this.fld2 = new SimpleObjectProperty<>(fld2val);
            this.fld3 = new SimpleObjectProperty<>(fld2val.add(fld1val));
            fld3.bind(Bindings.createObjectBinding(() -> 
                    fld1.get().add(fld2.get(),mc), fld1,fld2));
        }
    }
}