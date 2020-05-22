try (RecordingFile f = new RecordingFile(Paths.get("recording.jfr"))) {
   Map<String, SimpleEntry<String, Integer>> histogram = new HashMap<>();
   int total = 0;
   while (f.hasMoreEvents()) {
     RecordedEvent event = f.readEvent();
     if (event.getEventType().getName().endsWith(".ExecutionSample")) {
       RecordedStackTrace s = event.getStackTrace();
       if (s != null) {
         RecordedFrame topFrame= s.getFrames().get(0);
         if (topFrame.isJavaFrame())  {
           RecordedMethod method = topFrame.getMethod();
           String methodName = method.getType().getName() + "#" + method.getName() + " " + method.getDescriptor();
           Entry entry = histogram.computeIfAbsent(methodName, u -> new SimpleEntry<String, Integer>(methodName, 0));
           entry.setValue(entry.getValue() + 1);
           total++;
         }
       }
     }
   }
   List<SimpleEntry<String, Integer>> entries = new ArrayList<>(histogram.values());
   entries.sort((u, v) -> v.getValue().compareTo(u.getValue()));
   for (SimpleEntry<String, Integer> c : entries) {
     System.out.printf("%2.0f%% %s\n", 100 * (float) c.getValue() / total, c.getKey());
   }
   System.out.println("\nSample count: " + total);
 }