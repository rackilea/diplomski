JPanel panel = new JPanel( new GridBagLayout() );
panel.add(...);
panel.add(...);

//scroller=new JScrollPane();
scroller=new JScrollPane(panel);
...
//timeLineDialog.getContentPane().add(scroller);
timeLineDialog().add(scroller);