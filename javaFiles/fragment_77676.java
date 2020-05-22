static class CountMatchesMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text outputKey = new Text();
    private Text outputValue = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context ctx) throws IOException, InterruptedException {
        String row = value.toString();
        String[] row_part = row.split(",");
        outputKey.set(row_part[1]);
        outputValue.set(row_part[2]);
        ctx.write(outputKey, outputValue);
    }
}

static class CountMatchesReducer extends Reducer<Text, Text, Text, NullWritable> {
    private Text output = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context ctx) throws IOException, InterruptedException {
        HashMap<String, Integer> productCounts = new HashMap();

        int totalProductsBought = 0;
        for (Text value : values) {
            String productBought = value.toString();
            int count = 0;
            if (productCounts.containsKey(productBought)) {
                count = productCounts.get(productBought);
            }
            productCounts.put(productBought, count + 1);
            totalProductsBought += 1;
        }

        String topProduct = getTopProductForPerson(productCounts);
        output.set(key.toString() + " " + totalProductsBought + " " + topProduct);
        ctx.write(output, NullWritable.get());
    }

    private String getTopProductForPerson(Map<String, Integer> productCounts) {
        String topProduct = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> productCount : productCounts.entrySet()) {
            if (productCount.getValue() > maxCount) {
                maxCount = productCount.getValue();
                topProduct = productCount.getKey();
            }
        }
        return topProduct;
    }
}