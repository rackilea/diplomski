JLayeredPane layeredPane = new JLayeredPane();

layeredPane.add(new MyCanvas());
layeredPane.add(new MyPanel());

frame.add(layeredPane);