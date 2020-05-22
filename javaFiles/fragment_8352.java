JPanel drawPanel = new JPanel();
drawPanel.setLayout(new BorderLayout());
Canvas canvas = new Canvas();
canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
drawPanel.add(canvas, BorderLayout.CENTER);

// some code skipped

canvas.setIgnoreRepaint(true); //important
canvas.createBufferStrategy(2);

buffy = canvas.getBufferStrategy();