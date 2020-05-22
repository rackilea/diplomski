StringBuilder msg = new StringBuilder();
  while (start <= end) {
    msg.append(start).append(" ");
    start++;
  }

  JOptionPane.showMessageDialog(null, msg.toString());