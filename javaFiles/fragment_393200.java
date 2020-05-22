final JComboBox animalCombo = new JComboBox(animals);
    animalCombo.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(final JList list, Object value, final int index, final boolean isSelected,
                final boolean cellHasFocus) {

            if (index == -1) {
                value = "Animal: " + value;
            }

            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });