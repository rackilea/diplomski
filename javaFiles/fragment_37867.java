public class AnimatedChart
{

    private XYChart.Series<Number, Number> hourDataSeries;
    private XYChart.Series<Number, Number> minuteDataSeries;
    private NumberAxis xAxis;
    private Timeline animation;

    private Group view ;

    // more variables handling data manipulation based on time passing

    public AnimatedChart()
    {
        view = new Group();
        primaryStage.setScene(new Scene(view));
        view.getChildren().add(createChart());

        // create timeline to add new data every 60th of second
        animation = new Timeline();
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(1000 / 60), 
                                     new EventHandler<ActionEvent>()
                                     {
                                        @Override
                                        public void handle(ActionEvent actionEvent)
                                        {
                                            // 6 minutes data per frame
                                            for (int count = 0; count < 6; count++)
                                            {
                                                nextTime();
                                                plotTime();
                                            }
                                        }
                                     }));

        animation.setCycleCount(Animation.INDEFINITE);
    }

    public Parent getView() {
        return view ;
    }

    protected LineChart<Number, Number> createChart()
    {

        // Code to setup chart and starting data and return it - substitute
        // with:
        return new LineChart(new NumberAxis(0, 24, 3), new NumberAxis(0, 100, 10));
    }

    private void nextTime()
    {
        // Code to advance time variables
    }

    private void plotTime() {
        // update data series' based on time passing
    }

    public void play()
    {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }
}