Map<String, Handler> nameToHandler = new HashMap<>();
nameToHandler.put("Foo", new FooHandler());
nameToHandler.put("Bar", new BarHandler());

Map<Boolean, List<ToDo>> result = data.stream()
    .collect(Collectors.partitioningBy(task -> 
        nameToHandler.get(task.getTask()).handleTask(task)));