public void cleanup(Context context) {
    //Cleanup is called once at the end to finish off anything for reducer
    //Here we will write our final output

    List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

    Collections.sort(list, Map.Entry.comparingByValue(Comparator.reverseOrder()));

    for(Map.Entry<String,Integer> entry: list) {
        context.write(new Text(entry.getKey()), new IntWritable(entry.getValue()));
    }
}