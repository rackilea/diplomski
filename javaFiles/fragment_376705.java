JComponent comp = new JPanel();
MouseListener ml = new MouseAdapter() { /* Custom impl */ }
comp.addMouseListener(ml);

// ml is returned
MouseListener[] mls = comp.getListeners(MouseListener.class);

// Nothing is returned, as there's no support for adding listeners 
// for generic EventListeners to a component
EventListener[] els = comp.getListeners(EventListener.class);