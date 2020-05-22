IStreamMap<Integer, Integer> map = jet.getMap(randomString());
range(0, 10).parallel().forEach(i -> map.put(i, i));

JobConfig jobConfig = new JobConfig();
jobConfig.addClass(MyMapper.class);
List<Integer> list = map
    .stream()
    .configure(jobConfig)
    .map(new MyMapper())
    .collect(toList());