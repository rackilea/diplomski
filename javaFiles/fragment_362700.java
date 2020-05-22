public static class Item {
        private BooleanProperty selected = new SimpleBooleanProperty(false);
        final private String name;
        final private double averagePrice;
        final private int volume;

        Item(String name, double averagePrice, int volume) {

            this.name = name;
            this.averagePrice = averagePrice;
            this.volume = volume;
        }

        public BooleanProperty selectedProperty() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected.set(selected);
        }

        public boolean isSelected() {
            return selected.get();
        }

        public String getName() {
            return name;
        }

        public double getAveragePrice() {
            return averagePrice;
        }

        public int getVolume() {
            return volume;
        }

}