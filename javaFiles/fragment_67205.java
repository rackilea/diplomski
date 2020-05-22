Map<String,Integer> counters = new HashMap<>();
...
synchronized (counters) {

  String code = response.getStatusCode();
  Integer counter = counters.get(code);

  if (counter == null) {
    counters.put(code, 1);
  } else {
    counters.put(code, counter + 1)
  }
}