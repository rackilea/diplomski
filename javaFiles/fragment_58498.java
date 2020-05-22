ArrayList<String[]> lyricLineInfo = new ArrayList<String[]>();

String[] line = { "true", "true", "0.0", "5.0", "First Line" };
lyricLineInfo.add(line);
// now for a second style:
line = new String[5];
line[0] = "false";
line[1] = "false";
line[2] = "5.0";
line[3] = "10.0";
line[4] = "Second Line";
lyricLineInfo.add(line);
// and a third style:
lyricLineInfo.add(new String[] {
    "false", "true", "10.0", "15.0", "Third Line"
});

String secondLineTitle = lyricLineInfo.get(1)[4]; // will be "Second Line"