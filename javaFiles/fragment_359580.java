private Alert alert;
private Display display;
// Obtain display with display = Display.getDisplay(this); in consturctor

catch(Exception e) {
    alert = new Alert("Error occurred", "Message: " + e.getMessage(), null, AlertType.ERROR);
    alert.setTimeout(Alert.FOREVER);
    display.setCurrent(alert, form);
}