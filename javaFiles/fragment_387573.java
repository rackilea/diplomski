JPanel panel = new JPanel();
panel.setLayout( new BoxLayout(panel. BoxLayout.PAGE_AXIS) );
// create your loop to add child panels

JPanel wrapper = new JPanel(); // uses FlowLayout by default which respects the preferred size.
wrapper.add( panel );
frame.add( wrapper );