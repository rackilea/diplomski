private class KeyPressedHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
        case W:
            leftPaddle.setMoveUp(true);
            break;
        case S:
            leftPaddle.setMoveDown(true);
            break;
        default:
            break;
        }

    }

}