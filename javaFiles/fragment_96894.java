// Fill the map with colors you required
static Map<String, Color> colorMap = Map.ofEntries(Map.entry("RED", Color.RED),
        Map.entry("BLUE", Color.BLUE),
        Map.entry( "BLACK", Color.BLACK),
        Map.entry( "ORANGE", Color.ORANGE));

static Color getColor(String col)
{
        return colorMap.get(col.toUpperCase());
}

public void polygon(int xPoints[], int yPoints[], int nPoints, String col)
{
    this.graphics.drawPolygon(xPoints, yPoints, nPoints);
    this.graphics.setColor( getColor(col) );
}