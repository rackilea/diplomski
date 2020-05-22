JLayeredPane layeredFooPane = new JLayeredPane();
// The magic!
layeredFooPane.setLayout(new LayeredPaneLayout(layeredPane));
// Add components:
layeredFooPane.add(fooComponent, new Integer(JLayeredPane.DEFAULT_LAYER + 10));
layeredFooPane.add(barComponent, JLayeredPane.DEFAULT_LAYER);