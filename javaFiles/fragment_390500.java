HashMap<Class, BaseProcess> processMap = new HashMap<Class, BaseProcess>();

processMap.put(ObjectA.class, new ProcessClassA());
processMap.put(ObjectB.class, new ProcessClassB());
//... so on

Process p = new Process(processMap);
p.process(new ObjectA());