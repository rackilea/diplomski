String box = "Polygon((" 
                        + lx + " " + ry + ", "
                        + rx + " " + ry + ", "
                        + rx + " " + ly + ", "
                        + lx + " " + ly + ", "
                        + lx + " " + ry + "))";

ResultSet regionResult = stmt.executeQuery(//setBox + 
  "SELECT ItemID FROM ItemPoint WHERE MBRContains(GeomFromText(' " + box +  " '), Coords);\n");