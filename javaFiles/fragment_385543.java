public ChatBot() {
  super("Pollockoraptor");
  setSize(600, 400);
  setResizable(true);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  dialog.setEditable(false);
  dialog.setLineWrap(true);
  dialog.setOpaque(false);
  scroll.getViewport().setOpaque(false);
  input.addKeyListener(this);

  // **** adding a bunch of junk **without** constraings??
  window.add(scroll);  // *** add scrollpane *with* dialog here
  window.add(label);
  window.add(input);

  // .....

  GridBagConstraints c = new GridBagConstraints();
  c.fill = GridBagConstraints.HORIZONTAL;
  // Dialog
  c.weightx = 1.0;
  c.weighty = 1.0;
  c.anchor = GridBagConstraints.PAGE_START;
  c.fill = GridBagConstraints.BOTH;
  c.insets = new Insets(10, 10, 0, 10);
  c.gridx = 0;
  c.gridy = 0;
  c.gridwidth = 3;
  c.gridheight = 2;
  window.add(dialog, c); // *** then add dialog by itself*** ???? WTF???