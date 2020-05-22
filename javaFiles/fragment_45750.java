final JSlider jSlider1 = new JSlider();
    jSlider1.setValue(0);
    jSlider1.setMaximum(100);
    jSlider1.setBounds(0, 50, 300, 50);
    final Timer increaseValue = new Timer(50, new ActionListener() {// 50 ms interval in each increase.
        public void actionPerformed(ActionEvent e) {
            if (jSlider1.getMaximum() != jSlider1.getValue()) {
                jSlider1.setValue(jSlider1.getValue() + 1);
            } else {
                ((Timer) e.getSource()).stop();
            }
        }
    });
    panel.add(jSlider1);
    JButton moveSlider = new JButton("Start");
    moveSlider.setBounds(10, 106, 55, 30);
    moveSlider.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            increaseValue.start();
        }
    });
    panel.add(moveSlider);