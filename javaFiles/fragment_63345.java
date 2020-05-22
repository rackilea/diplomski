/** return time in format 1:23.456 */
private String getTimeString(long millis) {
    int minutes = (int) (millis / (1000 * 60));
    int seconds = (int) ((millis / 1000) % 60);
    int milliseconds = (int) (millis % 1000);
    String.format("%d:%02d.%03d", minutes, seconds, milliseconds);
}