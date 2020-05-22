Polygon polygon = new Polygon();
polygon.addPoint(250, 50);
polygon.addPoint(350, 50);
polygon.addPoint(450, 150);
polygon.addPoint(350, 150);
g.setClip(polygon);
g.drawImage(originalImage, 0, 0, null);