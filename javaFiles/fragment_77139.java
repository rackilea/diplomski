// Register your devices
Map<String, Device> devices = new HashMap<>();
devices.put("c0", c0);
devices.put("c1", c1);
devices.put("c2", c2);
devices.put("c3", c3);
...

public void onConnection(InputStream in) {
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader buffReader = new BufferedReader(isr);
    buffReader.lines()
              .parallel()
              .map(s -> s.split(" "))
              .flatMap(Arrays::stream)
              .map(s -> s.split("(?<=_)", 2))
              .forEach(p -> executor.submit(
                      () -> devices.get(p[0]).execute(p[1])
               ));
}