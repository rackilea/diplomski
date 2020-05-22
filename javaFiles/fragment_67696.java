JPanel mainPanel = new JPanel();
FlowLayout experimentLayout = new FlowLayout();
mainPanel.setLayout(experimentLayout);
for(int j =0; j < list.size(); j++) {
        masterPanel[j] = new JPanel();
        SerialNoLabel[j] = new JLabel(list.get(j));
        masterPanel[j].add(SerialNoLabel[j]);
        combo1[j] = new JComboBox();
        masterPanel[j].add(combo1[j]);
        combo2[j] = new JComboBox();
        masterPanel[j].add(combo2[j]);
        combo3[j] = new JComboBox();
        mainPanel.add(masterPanel[j]);
    }