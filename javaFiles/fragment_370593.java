JFreeChart chart = createChart(createDataset());
SVGGraphics2D g2 = new SVGGraphics2D(600, 400);
Rectangle r = new Rectangle(0, 0, 600, 400);
chart.draw(g2, r);
File f = new File("SVGBarChartDemo1.svg");
SVGUtils.writeToSVG(f, g2.getSVGElement());