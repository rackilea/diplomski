JPanel panel = new JPanel();
panel.add(new JButton("OK"));
panel.add(new JButton("Cancel"));
panel.add(new JButton("Custom"));

JOptionPane.showOptionDialog(null, "Message", "Title", JOptionPane.DEFAULT_OPTION,
  JOptionPane.INFORMATION_MESSAGE, null, new Object[] { panel }, null);