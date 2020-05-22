JPanel canvas = new JPanel();
canvas.setPreferredSize( new Dimension(300, 300) );
canvas.setBackground(Color.RED);

JPanel wrapper = new JPanel( new GridBagLayout() );
wrapper.add(canvas, new GridBagConstraints() );

frame.add(new JScrollPane(wrapper));