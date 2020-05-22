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