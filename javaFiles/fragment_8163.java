public class KeyTypedListener implements EventHandler<KeyEvent> {

    private boolean disabled = false;
    private Map<String, String> charCombinations = new HashMap<>();
    private KeyEvent pendingEvent;

    public KeyTypedListener() {
        charCombinations.put("¨ι", "ϊ");
        charCombinations.put("¨Ι", "Ϊ");
    }

    @Override
    public void handle(final KeyEvent event) {

        if (disabled || event.getCharacter() == null
                || event.getCharacter().length() != 1) {
            return;
        }

        final String typed = event.getCharacter();

        if (pendingEvent == null && isCombiCharacter(typed)) {
            pendingEvent = event.copyFor(event.getSource(), event.getTarget());
            event.consume();

        } else if (pendingEvent != null) {
            String combination =
                    charCombinations.get(pendingEvent.getCharacter() + typed);

            if (combination == null) {
                disabled = true;
                fireEvent(pendingEvent);
                disabled = false;
                pendingEvent = null;
            } else {
                event.consume();
                pendingEvent = null;

                Platform.runLater(() -> {
                    fireEventWithCharacter(event, combination);
                });
            }
        }
    }

    private boolean isCombiCharacter(final String character) {
        return "¨".equals(character);
    }

    private void fireEvent(final KeyEvent event) {
        Event.fireEvent(event.getTarget(), event);
    }

    private void fireEventWithCharacter(final KeyEvent event,
            final String character) {
        fireEvent(new KeyEvent(event.getSource(), event.getTarget(),
                event.getEventType(), character, "", KeyCode.UNDEFINED,
                event.isShiftDown(), event.isControlDown(), event.isAltDown(),
                event.isMetaDown()));
    }
}