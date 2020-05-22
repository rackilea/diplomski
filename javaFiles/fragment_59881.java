textFieldInput.setOnKeyPressed(event -> {
        if (event.isControlDown()) {
            KeyEvent newEvent= new KeyEvent(null, null, null, null, false, false, false, false);
            textFieldInput.fireEvent(newEvent);
        }
        event.consume();
        if (event.getCode() == KeyCode.ENTER) {
            send(textFieldInput.getText());
        }

    });