MigLayout layout = new MigLayout("debug", "[][]");
    JComponent content = new JPanel(layout);
    content.add(new JLabel("Words are separated by: "), "span");
    JRadioButton radio = new JRadioButton("Lines or tabs");
    content.add(radio, "wrap");
    // split the cell so it will contain both the other button
    // and the textfield
    content.add(new JRadioButton("Other:"), "split 2");
    // get the right margin of the upper radiobutton
    int rightMargin = radio.getInsets().right; 
    content.add(new JTextField(), "grow, wrap, " +
        // remove the gap to the preceding radiobutton
            "gapx 0, " +
        // set the padding to compensate the right edge
            "pad 0 0 0 -" + rightMargin + "px");
    content.add(new JButton("Format"), "span, center");
    showInFrame(content, "align to button text");