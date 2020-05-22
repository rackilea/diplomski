JPanel container = new JPanel();
container .setLayout(new BoxLayout(container , BoxLayout.Y_AXIS));

JPanel childTop = new JPanel();
JPanel childCenter = new JPanel();
JPanel childBottom = new JPanel();


childTop.setMaximumSize(...);
childBottom.setMaximumSize(...);

container.add(childTop);
container.add(Box.createVerticalGlue());
container.add(childCenter);
container.add(Box.createVerticalGlue());
container.add(childBottom);