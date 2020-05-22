public void actionPerformed(ActionEvent event) {

        String s = selected.getText();
        if (event.getSource() == buttonR) {
            x.setText("");
            y.setText("");
            z.setText("");
        } else if (event.getSource() == buttonE) {
            int result = Integer.parseInt(x.getText()) - Integer.parseInt(y.getText());
            z.setText(String.valueOf(result));
        } else {
            String command = event.getActionCommand();
            selected.setText(s + command);
        }
    }