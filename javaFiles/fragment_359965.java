public void mousePressed (MouseEvent me) {
  JLabel label = labels.get(11);
  label.scrollRectToVisible(new Rectangle(0,0,label.getWidth(), label.getHeight()));

  //Point loc = label.getLocation();
  Point loc = new Point(0,0);
  Point wrPos = SwingUtilities.convertPoint(label, loc, lPane);
  floatingLabel.setLocation(wrPos);
  floatingLabel.setVisible(true);
}

public void adjustmentValueChanged(AdjustmentEvent ae) {
  System.out.println("adjustmentValueChanged: " + ae.getValue());

  JLabel label = labels.get(11);

  Point loc = new Point(0,0);
  Point wrPos = SwingUtilities.convertPoint(label, loc, lPane);
  floatingLabel.setLocation(wrPos);
  floatingLabel.setVisible(true);
}