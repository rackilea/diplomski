ArrayList<ArrayList<String>> lyricLineInfo = new ArrayList<ArrayList<String>>();

ArrayList<String> line = new ArrayList<String>();
line.add("true");
line.add("true");
line.add("0.0");
line.add("5.0");
line.add("First Line");
lyricLineInfo.add(line);
line = new ArrayList<String>(); // don't use clear(): need a new object here
line.add("false");
line.add("false");
line.add("5.0");
line.add("10.0");
line.add("Second Line");
lyricLineInfo.add(line);

String secondLineTitle = lyricLineInfo.get(1).get(4); // will be "Second Line"