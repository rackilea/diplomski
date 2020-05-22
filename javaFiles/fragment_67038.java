Component[] comps = panel.getComponents();
GridBagLayout layout =  (GridBagLayout) panel.getLayout();

for (int i = 0; i < comps.length; ++i) {
    Component comp = comps[i];
    GridBagConstraints gbc = layout.getConstraints(comp);
    System.out.println("Component : " + comp + " , with GBC: " + gbc);
}