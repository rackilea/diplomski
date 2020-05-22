private JPanel proficinciesAndSkillsPanel()
{
    JPanel result = new JPanel();  // ******** here *********
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.weightx = 1;
    gbc.weighty = 1;

    result.add(labeledTextField("Inspiration", inspirationField = new JTextField(2), null, 1), gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;

    result.add(labeledTextField("Proficiency bonus", proficiencyField = new JTextField(2), null, 1),gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;

    result.add(labeledRadioField("Strength", strSTField = new JTextField(2), strRB = new JRadioButton()),gbc);

    return result;
}