JLabel label = new JLabel("small");
Dimension d = label.getPreferredSize();
PropertyChangeListener l = new PropertyChangeListener() ...
    boolean called;
    propertyChanged(...) 
        called = true;
label.addPropertyChangeListener("preferredSize", l);
label.setText("just some longer text");
if (!d.equals(label.getPreferredSize())
   assertTrue("listener must have been notified", l.called);