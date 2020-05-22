while(res.next()){
    JCheckBox checkBox = new JCheckBox(res.getString("NAME"));

    checkBoxes.add(checkBox);
    panel.add(checkBox);

    checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    infos.add(checkBox.getText());
                }
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                    infos.remove(checkBox.getText());
                }
            }
    });
}