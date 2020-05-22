import javafx.collections.FXCollections;
   import javafx.collections.ObservableList;
   import javafx.embed.swing.JFXPanel;
   import javafx.geometry.Side;
   import javafx.scene.Scene;
   import javafx.scene.chart.PieChart;
   import javafx.scene.control.ScrollPane;
   import javax.swing.JFrame;
   import javax.swing.JPanel;

public class Pie_Chart extends JFrame {

public static void main(String[] args) {
    Pie_Chart pc=new Pie_Chart();
    pc.getContentPane().add(new CenterPaneel());
    pc.setVisible(true);
}
}


class CenterPaneel extends JPanel{
private final static ObservableList<PieChart.Data> details =   FXCollections.observableArrayList();
private static PieChart pieChart;
    public CenterPaneel(){
    setLayout( new GridLayout(2,3,10,10));


    final JFXPanel dataPaneel = new JFXPanel();

    ScrollPane sp = new ScrollPane();

    details.addAll(new PieChart.Data("test1", 25),
            new PieChart.Data("test 2", 25),
            new PieChart.Data("test 3", 25),
            new PieChart.Data("test 4", 25)
        );
    pieChart = new PieChart();
    pieChart.setData(details);
    pieChart.setTitle("test");
    pieChart.setLegendSide(Side.BOTTOM);
    pieChart.setLabelsVisible(true);
    sp.setContent(pieChart);

    Scene scene = new Scene(sp, 600, 500);
    dataPaneel.setScene(scene);

    add( new Catagorie1Paneel() );                add( new Catagorie3Paneel() );           add( new SamenvattingPaneel() );
    add( new Catagorie2Paneel() );                add( new Catagorie4Paneel() );           add( dataPaneel);
}
}