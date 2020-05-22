private void GroupButton() {
    orderTypesPanel = new JPanel(new GridLayout(3, 1));
    orderTypesPanel.setOpaque(false);

    // declare 3 JRadioButton variables
    JRadioButton rInstall = new JRadioButton("Installation");
    JRadioButton rProject = new JRadioButton("Project");
    JRadioButton rMaintain = new JRadioButton("Maintenance");

    rInstall.setForeground(Color.white);
    rInstall.setOpaque(false);

    rProject.setForeground(Color.white);
    rProject.setOpaque(false);

    rMaintain.setForeground(Color.white);
    rMaintain.setOpaque(false);

    orderTypesPanel.add(rInstall);
    orderTypesPanel.add(rProject);
    orderTypesPanel.add(rMaintain);

    // declare new ButtonGroup
    ButtonGroup butgro = new ButtonGroup();

    // add three buttons to ButtonGroup
    butgro.add(rInstall);
    butgro.add(rProject);
    butgro.add(rMaintain);

}