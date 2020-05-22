import java.awt.Color;

public enum WayType {
    UNKNOWN(Color.Black), BUILDING(Color.Gray), WATER(Color.Blue), 
    COASTLINE(Color.DarkBlue), LANDUSE(Color.Green) /*... to complete*/;

    private Color color;

    private WayType(Color color) {
        this.color=color;
    }
    public Color getColor() {
        return color;
    }
}