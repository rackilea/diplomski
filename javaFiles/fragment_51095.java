public ComboboxWithoutDottedBorder() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}
       this.setVisible(true);
       JLabel label = new JLabel("Label");
       JComboBox<String> combo = new JComboBox<>();
       this.setLayout(new BorderLayout());
       combo.addItem("A");
       combo.addItem("B");
       combo.addItem("C");
       combo.addItem("D");
       combo.setUI(new BasicComboBoxUI());

       this.add(label, BorderLayout.NORTH);
       this.add(combo, BorderLayout.SOUTH);
    }