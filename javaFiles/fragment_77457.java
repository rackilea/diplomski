@Component
public class ProcessHandler extends RouteBuilder {

            @Override
            protected void defineRoute() throws Exception {

            DataFormat csv = new BindyCsvDataFormat(CsvModel.class);

            rest("/")
                    .post().produces("application/json")
                         .route()
                              .unmarshal(csv)
                              .split().method(ItemsSplittingStrategy.class, "splitItems")
                                  .parallelProcessing()
                                  .marshal().json(JsonLibrary.Gson)
                              .end()
                    .to("file:/file.json");
    }
}