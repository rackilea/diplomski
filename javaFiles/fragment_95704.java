final String first = data.first();
JavaRDD<String> filteredData = data.filter(new Function<String, Boolean>() {
  @Override public Boolean call(String s) {
    return !s.contains(first);
  }
});