JPane panel = (JPanel) frame.getContentPane();
panel.setLayout(new MigLayout("fill, wrap 2", "[right][fill]"));

panel.add(lengthL);
panel.add(new JTextField());
panel.add(widthL);
panel.add(new JTextField());
panel.add(areaL);
panel.add(new JTextField());
panel.add(perimeterL);
panel.add(new JTextField());