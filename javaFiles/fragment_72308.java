ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine se = sem.getEngineByExtension("js");
    int time_in_ms = 3000;
    se.put("ms", time_in_ms);
    Instant before = Instant.now();
    se.eval("java.lang.Thread.sleep(ms)");
    Instant after = Instant.now();
    System.out.printf("Expected: %dms Actual %dms%n", time_in_ms, Duration.between(before, after).toMillis());