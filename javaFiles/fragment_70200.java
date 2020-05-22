if (cmp instanceof JComboBox)
        {
            ((JComboBox)cmp).setRenderer(new DefaultListCellRenderer() {
                private ListCellRenderer superLCR = ((JComboBox)cmp).getRenderer();
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component comp = superLCR.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (isSelected)
                        comp.setBackground(new Color(164,164,164));
                    return comp;
                }
            });
        }