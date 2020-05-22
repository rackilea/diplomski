String text = "\u202Eca 12 \u05D1\u05D3\u05D9\u05E7\u05D4";

    JLabel testLabel = new JLabel();
    testLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT );
    testLabel.setText(text);
    testLabel.setBorder( new LineBorder( Color.BLACK ) );