labelPanel= new JPanel();
//set this up to order things vertically
labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
lRows = new JLabel[n];

for (int i=0;i<n;i++){
    lRows[i]=new JLabel(Arrays.toString(tri.tri[i]));
    //to center your label, just set the X alignment
    lRows[i].setAlignmentX(Component.CENTER_ALIGNMENT)
    labelPanel.add(lRows[i]);
}