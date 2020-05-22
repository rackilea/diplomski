int digit = Integer.parseInt(DigitValue.getText());
boolean[][] mask = { { false, false, true, false, false, true, false },
        { true, false, true, true, true, false, true },
        { true, false, true, true, false, true, true },
        { false, true, true, true, false, true, false },
        { true, true, false, true, false, true, true },
        { true, true, false, true, true, true, true },
        { true, false, true, true, false, true, false },
        { true, true, true, true, true, true, true },
        { true, true, true, true, false, true, true } };
boolean[] digits = mask[digit - 1];
Digi1.setVisible(digits[0]);
Digi2.setVisible(digits[1]);
Digi3.setVisible(digits[2]);
Digi4.setVisible(digits[3]);
Digi5.setVisible(digits[4]);
Digi6.setVisible(digits[5]);
Digi7.setVisible(digits[6]);