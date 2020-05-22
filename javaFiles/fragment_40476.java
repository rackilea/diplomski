JFrame frame = new JFrame("Foo");
frame.pack();
frame.setVisible(true);

// in some listener
frame.dispose(); // it's no longer visible
System.out.println("is frame null? " + (frame == null));