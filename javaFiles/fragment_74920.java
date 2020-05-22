LineSegment ascentLine = renderInfo.getAscentLine();
LineSegment descentLine = renderInfo.getDescentLine();
float llx = descentLine.getStartPoint().get(Vector.I1);
float lly = descentLine.getStartPoint().get(Vector.I2);
float urx = ascentLine.getEndPoint().get(Vector.I1);
float ury = ascentLine.getEndPoint().get(Vector.I2);
rectangle = new Rectangle(llx, lly, urx, ury);