layout.setVerticalGroup(
    layout.createSequentialGroup()
      .addGroup(layout.createParallelGroup()
        .addComponent(button1)
        .addComponent(button2)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(button3))
      .addComponent(textarea)
  );