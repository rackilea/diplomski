public enum Topic {
    SUNNY("WEATHER.SUNNY"), CLOUDY("WEATHER.CLOUD"), ...

    String notation;

    Topic(String notation) {
        this.notation = notation;
    }

    public String getNotation() { return notation; }
}