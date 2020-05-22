/** return time in format 1:23.45 */
private String getTimeString(long millis) {
    int minutes = (int) (millis / (1000 * 60));
    int seconds = (int) ((millis / 1000) % 60);
    int seconds100 = (int) ((millis / 10) % 100);
    String.format("%d:%02d.%02d", minutes, seconds, seconds100);
}