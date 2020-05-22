RelativeLayout rl = new RelativeLayout(RelativeLayout.Y_AXIS);
rl.setFill( true );
rl.setRoundingPolicy(...); // or use the default
//container.setLayout(new GridBagLayout());
container.setLayout( rl );
...
//container.add(header, gbc);
container.add(header); // display at preferred size
...
//container.add(content, gbc);
container.add(content, new Float(0.9f));
...
//container.add(footer, gbc);
container.add(footer, new Float(0.1f));