import java.awt.Color;

public class EventBox {

    private Color floorColor;

    private EventBox() {
        this.floorColor = null;
    }

    public Color getFloorColor() {
        return floorColor;
    }

    private void setFloorColor(Color floorColor) {
        this.floorColor = floorColor;
    }

    public static EventBoxBuilder builder() {
        return new EventBoxBuilder();
    }

    public static class EventBoxBuilder {
        private final EventBox box;

        EventBoxBuilder() {
            this.box = new EventBox();
        }

        public EventBoxBuilder setFloorColor(Color color) {
            box.setFloorColor(color);
            return this;
        }

        public EventBox build() {
            return box;
        }
    }
}
....
scriptUtils.runScript("sc-cfrmd",EventBox.builder().setFloorColor(floorColor).build());