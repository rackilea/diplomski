public static void loadToJSON(LocalDate startDate, LocalDate endDate, Controller controller) {

    Task<Integer> task = new Task<Integer>() {
        @Override
        protected Integer call() throws Exception {
            double MIN_VAL = Double.MAX_VALUE;
            double MAX_VALUE = Double.MIN_VALUE;
            XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

            Platform.runLater(() -> controller.chart.getData().add(series));

            for (LocalDate date = startDate; !date.isEqual(endDate.plusDays(1)); date = date.plusDays(1)) {

                String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                URLConnection urlCon = null;

                String baseURL = "http://api.fixer.io/";
                try {
                    URL url = new URL(baseURL + formattedDate + "?symbols=PLN,EUR");
                    urlCon = url.openConnection();

                    InputStreamReader in = new InputStreamReader(urlCon.getInputStream());
                    ObjectMapper mapper = new ObjectMapper();
                    ExchangeRate jsonObject = mapper.readValue(in, ExchangeRate.class);

                    if (MIN_VAL > jsonObject.getRates().get("PLN"))
                        MIN_VAL = jsonObject.getRates().get("PLN");
                    if (MAX_VALUE < jsonObject.getRates().get("PLN"))
                        MAX_VALUE = jsonObject.getRates().get("PLN");
                    in.close();

                    // Not sure why you are doing this?
                    // series.getData().clear();


                    Plaform.runLater(() -> 
                        series.getData().add(new XYChart.Data<String, Number>(formattedDate, jsonObject.getRates().get("PLN"))));

                    // controller.chart.getData().add(series);

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Platform.runLater(() -> 
                    controller.messageBox.setText("Best exchange rate : " + MIN_VAL + " \nWorst exchange rate : " + MAX_VALUE));
            return null;
        }
    };
    Thread th = new Thread(task);
    th.setDaemon(true);
    th.start();
}