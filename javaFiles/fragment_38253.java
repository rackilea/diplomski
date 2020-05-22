// add all visible components which should not grow
GridBagLayout gridBagLayout = new GridBagLayout();
JPanel filesPanel = new JPanel(gridBagLayout);
GridBagConstraints c = new GridBagConstraints();
c.gridx = GridBagConstraints.REMAINDER;
for(int i=0; i<15; i++)
    filesPanel.add(new JLabel("Test row " + i), c);

// add an extra row consuming vertical extra space
int nRows=filesPanel.getComponentCount();
gridBagLayout.rowHeights=new int[nRows+1];
gridBagLayout.rowWeights=new double[nRows+1];
gridBagLayout.rowWeights[nRows]=1;
// add an extra column consuming extra horizontal space
gridBagLayout.columnWidths=new int[] { 0, 0 };
gridBagLayout.columnWeights=new double[] { 0, 1 };