private String s1 = "";
private String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "x";
private static final Pattern p1 = Pattern.compile("^x");
private static final Pattern p2 = Pattern.compile("x");

@GenerateMicroBenchmark
public boolean p1s1() { return p1.matcher(s1).find(); }

@GenerateMicroBenchmark
public boolean p1s2() { return p1.matcher(s2).find(); }

@GenerateMicroBenchmark
public boolean p2s1() { return p2.matcher(s1).find(); }

@GenerateMicroBenchmark
public boolean p2s2() { return p2.matcher(s2).find(); }