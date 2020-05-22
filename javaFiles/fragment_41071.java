import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Function<String, double[]> lineToXy = new Function<String, double[]>() {
            @Override
            public double[] apply(String line) {
                String[] s = line.split(" ", 0);
                double x = Double.parseDouble(s[0]);
                double y = Double.parseDouble(s[1]);
                return new double[] { x, y };
            }
        };

        try {
            //input file name is data.txt
            File file = new File("./data.txt");
            List<String> lines = Files.readLines(file, Charsets.UTF_8);
            List<double[]> xyList = Lists.transform(lines, lineToXy);
            XYSeriesCollection data = new XYSeriesCollection();
            XYSeries series = new XYSeries("XY Series");
            for (double[] xy : xyList) {
                series.add(xy[0], xy[1]);
            }
            data.addSeries(series);

            JFreeChart chart = ChartFactory.createXYLineChart("Tilte",
                "xLabel", "yLabel", data, PlotOrientation.VERTICAL, true,
                false, false);
            //output png file name is graph.png
            File png = new File("./graph.png");
            ChartUtilities.saveChartAsPNG(png, chart, 400, 300);
        } catch (Exception e) {
            //error handling
        } finally {
            //file close,and so on.
        }
        System.exit(0);
    }
}