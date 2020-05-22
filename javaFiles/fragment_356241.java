JPanel panel = new JPanel(new MigLayout());
panel.add(label, "split 2, span");
panel.add(separator, "growx, wrap");
panel.add(anotherLabel);
panel.add(button1);
panel.add(button2);