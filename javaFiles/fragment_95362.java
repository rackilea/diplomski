buttonContainer.addComponentListener(new ComponentListener() {
    @Override
    public void componentResized(ComponentEvent ce) { // just implementing this
        fixComponentWidths(buttonContainer, buttons, BUTTON_HEIGHT);
        // where buttonContainer is a JPanel,
        // buttons is a List of JButtons
        // BUTTON_HEIGHT, well the height of the button!
    }

    @Override
    public void componentMoved(ComponentEvent ce) { // not needed
    }

    @Override
    public void componentShown(ComponentEvent ce) { // not needed
    }

    @Override
    public void componentHidden(ComponentEvent ce) { // not needed
    }
});