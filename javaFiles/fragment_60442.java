// I define a width of 200pt
float width = 200;
// I define the height as 10000pt (which is much more than I'll ever need)
float max = 10000;
// I create a column without a `writer` (strange, but it works)
ColumnText ct = new ColumnText(null);
ct.setSimpleColumn(new Rectangle(width, max));
for (Element e : el) {
    ct.addElement(e);
}
// I add content in simulation mode
ct.go(true);
// Now I ask the column for its Y position
float y = ct.getYLine();