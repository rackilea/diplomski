Frame frame = new Frame();
TextField text = new TextField();
frame.add(text);
frame.pack();
frame.setVisible(true);

text.dispatchEvent(new KeyEvent(frame,
        KeyEvent.KEY_TYPED, 0,
        0,
        KeyEvent.VK_UNDEFINED, 'H'));