Area area = new Area();
for (Rectangle temp : this.rects) {
    System.out.println(temp);
    area.add(new Area(temp));
}
Rectangle bounds = area.getBounds();
System.out.println("bounds = " + bounds);
Dimension size = new Dimension(bounds.x + bounds.width, bounds.y + bounds.height);