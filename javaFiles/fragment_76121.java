public boolean verify(JComponent input) {

        maleRb.setEnabled(false);
        femaleRb.setEnabled(false);

        String name = input.getName();
        if (name.equals("fntf")) {
            String text = ((JTextField) input).getText().trim();
            if (text.matches(".*\\d.*")) return false;       // Have Digit
        } else if (name.equals("lntf")) {
            String text = ((JTextField) input).getText();
            if (text.matches(".*\\d.*")) return false;
        }

        maleRb.setEnabled(true);
        femaleRb.setEnabled(true);
        return true;
    }