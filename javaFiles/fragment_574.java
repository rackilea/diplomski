import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

try
      {
          String host="Database address here";
               Connection conn;
               conn = DriverManager.getConnection(host,"username","password");
         final String SQL = "SELECT column1, column2 FROM table_name";
         final CategoryDataset dataset = new JDBCCategoryDataset(conn, SQL);
         JFreeChart chart = ChartFactory.createBarChart("Report","X-Axis","Y-Axis", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catplot = chart.getCategoryPlot();
        catplot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartpanel = new ChartPanel(chart);
       jPanel1.removeAll();
        jPanel1.add(chartpanel, BorderLayout.CENTER);
        jPanel1.validate();    
      }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }