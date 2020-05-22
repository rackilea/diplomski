import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartSample extends Application
{

    String alphbets = "abcdefghij";

    @Override
    public void start(Stage stage)
    {
        List<DataFrame> fakeData = generateFakeDataFrames();
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        //creating the chart
        final LineChart<String, Number> lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Fake Chart");

        //defining a series
        List<XYChart.Series<String, Number>> seriesList = new ArrayList();
        for (int i = 0; i < alphbets.length(); i++) {
            XYChart.Series<String, Number> series = new XYChart.Series();
            series.setName(alphbets.charAt(i) + "");
            seriesList.add(series);
        }

        for (int i = 0; i < seriesList.size(); i++) {
            char tempChar = alphbets.charAt(i);
            //Filter the fake data
            List<DataFrame> subList = fakeData.stream().filter((t) -> {
                return t.getId() == tempChar;
            }).collect(Collectors.toList());

            //Add the filtered data to the correct series
            for (DataFrame dataFrame : subList) {
                System.out.println(seriesList.get(i).getName() + " :" + dataFrame.getId() + "  " + dataFrame.getDate() + "  " + dataFrame.getTotal());//Check to see if data is correct.
                seriesList.get(i).getData().add(new XYChart.Data(dataFrame.getDate(), dataFrame.getTotal()));
            }
        }
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(seriesList);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public List<LocalDate> createDates()
    {
        List<LocalDate> localDates = new ArrayList();

        LocalDate localDate = LocalDate.of(1985, Month.FEBRUARY, 4);
        for (int i = 0; i <= 4; i++) {
            localDates.add(localDate.plusDays(i));
        }

        return localDates;
    }

    public List<DataFrame> generateFakeDataFrames()
    {
        Random random = new Random();

        List<DataFrame> dataFrames = new ArrayList();

        List<LocalDate> dates = createDates();
        for (int i = 0; i < 50; i++) {

            double total = (random.nextDouble() * 2 - 1) * 3;
            double val = (random.nextDouble() * 2 - 1) * 2000;

            dataFrames.add(new DataFrame(alphbets.charAt(i % 10), dates.get(i / 10).toString(), total, val));
        }

        return dataFrames;
    }
}