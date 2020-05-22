@Override
public void append(String str) {
    String[] lines = str.split("\r\n|\r|\n");
    int rows = lines.length;
    for (String line : lines) {
        super.append(line + "\n");
        if (line.contains("Exception")) {
            exPoint.add(new Point(rowCount, 1)); // 1 line
        }
        ++rowCount;
    }
}