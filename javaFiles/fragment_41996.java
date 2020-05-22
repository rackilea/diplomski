public class DFJob {

    public static class StringToRowConverter extends DoFn<String, TableRow> {

        private String[] columnNames;

        private boolean isFirstRow = true;

        public void processElement(ProcessContext c) {
            TableRow row = new TableRow();

            String[] parts = c.element().split(",");

            if (isFirstRow) {
                columnNames = Arrays.copyOf(parts, parts.length);
                isFirstRow = false;
            } else {
                for (int i = 0; i < parts.length; i++) {
                    row.set(columnNames[i], parts[i]);
                }
                c.output(row);
            }
        }
    }

    public static void main(String[] args) {
        DataflowPipelineOptions options = PipelineOptionsFactory.create()
                .as(DataflowPipelineOptions.class);
        options.setRunner(BlockingDataflowPipelineRunner.class);

        Pipeline p = Pipeline.create(options);

        p.apply(TextIO.Read.from("gs://dataflow-samples/myfile.csv"))
                .apply(ParDo.of(new StringToRowConverter()))
                .apply(BigQueryIO.Write.to("myTable")
                        .withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_NEVER)
                        .withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND));

        PipelineResult result = p.run();
    }
}