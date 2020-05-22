GroupLayout layout = new GroupLayout(container);
container.setLayout(layout);
layout.setAutoCreateContainerGaps(true);
layout.setAutoCreateGaps(true);

Group groupLabels = layout.createParallelGroup();
Group groupFields = layout.createParallelGroup();
Group groupRows = layout.createSequentialGroup();

layout.setHorizontalGroup(layout.createSequentialGroup()
    .addGroup(groupLabels)
    .addGroup(groupFields));
layout.setVerticalGroup(groupRows);

for (int i = 0; i < 5; i++) {
    JLabel label = new JLabel("ABCDEFGHIJ".substring(0, 2 + 2 * i));
    JTextField field = new JTextField("ABCDEFGHIJ".substring(0, 2 + 2 * i));

    groupLabels.addComponent(label);
    groupFields.addComponent(field);
    groupRows.addGroup(layout.createParallelGroup()
        .addComponent(label)
        .addComponent(field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
}