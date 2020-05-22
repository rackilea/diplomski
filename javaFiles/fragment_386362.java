setLayout(new java.awt.GridBagLayout())
java.awt.GridBagConstraints constraints = new java.awt.GridBagConstraints();
constraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
constraints.weighty = 0.1;
constraints.weightx = 0.3;
javax.swing.JButton unlockButton = new javax.swing.JButton("jbutton text");
add(unlockButton, constraints);