public class PieChart extends JFrame {  

  private  PieDataset createDataset() {
            DefaultPieDataset result = new DefaultPieDataset();
            result.setValue("department1", 33.33);
            result.setValue("department2", 33.33);
            result.setValue("department3", 33.33);
            return result;

        }

     private JFreeChart createChart(PieDataset dataset, String title) {

            JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
                dataset,                // data
                true,                   // include legend
                true,
                false);

            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(290);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            return chart;

        }

}

public static void main(String[] args) {
          PieChart demo = new PieChart("Comparison", "Which operating system are you using?");
          demo.pack();
          demo.setVisible(true);
      }