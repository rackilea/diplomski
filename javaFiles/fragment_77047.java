JPanel labelPanel = new JPanel( new GridLayout(0, 1) );
labelPanel.add(new JLabel( "one" ) );
labelPanel.add(new JLabel( "two" ) );

JPanel wrapper = new JPanel( new BorderLayout() );
wrapper.add(labelPanel, BorderLayout.PAGE_START);

frame.add(wrapper, BorderLayout.CENTER);