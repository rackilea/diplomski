/** return time in format 1:23.4 */
private String getTimeString(long millis) {
    int minutes = (int) (millis / (1000 * 60));
    int seconds = (int) ((millis / 1000) % 60);
    int seconds10 = (int) ((millis / 100) % 10);
    String.format("%d:%02d.%d", minutes, seconds, seconds10);
}