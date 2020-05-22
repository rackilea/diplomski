int rows = 10;
int columns = 20;
MigLayout layout = new MigLayout(
        // set the automatic wrap after columns
        "insets 0, wrap " + columns, 
        // hardcode fixed column width and fixed column gap 
        "[50lp, fill]5lp", 
        // hardcode fixed height and a zero row gap
        "[20lp, fill]0");
JXPanel content = new JXPanel(layout);
content.setBackgroundPainter(new ImagePainter(XTestUtils.loadDefaultImage("moon.jpg")));
for (int r = 0; r < rows; r++) {
    // top gap on even rows
    String topGap = r != 0 && r % 2 == 0 ? "gaptop 5lp" : "";
    for (int i = 0; i < columns; i++) {
        JTextField field = new JTextField();
        content.add(field, topGap);
    }
}
showInFrame(content, "grid");