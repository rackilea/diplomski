public void actionPerformed(ActionEvent e) {
            int j = 0;
            r2 = Double.parseDouble(textField.getText());
            if (option.equals("+")) {
                result = r1 + r2;
            }
            if (option.equals("-")) {
                result = r1 - r2;
            }
            if (option.equals("*")) {
                result = r1 * r2;
            }
            if (option.equals("/")) {
                result = r1 / r2;
            }
            if ((result == Math.floor(result )) && !Double.isInfinite(result )) {
                 textField.setText((int)(result) + " ");
            } else textField.setText(result + " ");
        }