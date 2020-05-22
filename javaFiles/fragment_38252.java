GridBagLayout gridBagLayout = new GridBagLayout();
JPanel filesPanel = new JPanel(gridBagLayout);
GridBagConstraints c = new GridBagConstraints();
c.gridx = GridBagConstraints.REMAINDER;
c.anchor = GridBagConstraints.NORTHWEST;

c.weightx = 1; // for the column
for(int i=0; i<15; i++)
    filesPanel.add(new JLabel("Test row " + i), c);

// now change the last row:
c.weighty = 1;
gridBagLayout.setConstraints(
  filesPanel.getComponent(filesPanel.getComponentCount()-1), c);