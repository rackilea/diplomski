private class KeyReleasedHandler implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
        case W:
            leftPaddle.setMoveUp(false);
            break ;
        case S:
            leftPaddle.setMoveDown(false);
            break;
        default:
            break;
        }

    }

}