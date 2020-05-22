String str = "YOUR_VERY_LONG_STRING";
    String[] lines = str.split("\n");
    String[][] linesCsv = new String[lines.length][];

    for (int i=0; i<lines.length; i++) {
        linesCsv[i] = lines[i].split(",");
    }