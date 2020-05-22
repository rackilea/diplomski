public Drawing() {
        setBackground(Color.WHITE);
        pencil = new Pencil(this); // send the instance to `Pencil` by constructor.
        addMouseListener(pencil);
        addMouseMotionListener(pencil);
        addMouseListener(lines);
        addMouseMotionListener(lines);
        addMouseListener(paintbrush);
        addMouseMotionListener(paintbrush);
        this.repaint();
    }