// you create panel2 just fine
  JPanel panel2 = new JPanel();
  panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 10));

  // but you don't use it! Change below to panel2.
  panel1.add(jbtAdd);
  panel1.add(jbtSubtract);
  panel1.add(jbtMultiply);
  panel1.add(jbtDivide);