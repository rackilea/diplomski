MyListener myListener = new MyListener();
  for (int i = 0; i < SIZE; i++) {
     for (int j = 0; j < SIZE; j++) {
        JButton button = new JButton(DEFAULT);
        button.addActionListener(myListener);
        add(button);
        allButtons.add(button);
     }
  }
  Collections.shuffle(allButtons);
  for (int i = 0; i < NUGGET_COUNT; i++) {
     selectedButtons.add(allButtons.get(i));
  }