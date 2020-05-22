public class NameFirstWithMNHListCellRenderer extends JPanel implements ListCellRenderer<PatientData> {

    private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;

    private JLabel name;
    private JLabel mhn;

    public NameFirstWithMNHListCellRenderer() {
        name = new JLabel();
        mhn = new JLabel();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(name, gbc);
        gbc.gridx++;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(mhn, gbc);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends PatientData> list, PatientData value, int index, boolean isSelected, boolean cellHasFocus) {
        name.setText(value.getFirstName() + " " + value.getLastName());
        mhn.setText(value.getMHN());
        formatBackground(name, list, index, isSelected, cellHasFocus);
        formatBackground(mhn, list, index, isSelected, cellHasFocus);
        formatBackground(this, list, index, isSelected, cellHasFocus);
        formatForeground(name, list, index, isSelected, cellHasFocus);
        formatForeground(mhn, list, index, isSelected, cellHasFocus);
        formatForeground(this, list, index, isSelected, cellHasFocus);

        formatBorder(this, list, index, isSelected, cellHasFocus);

        return this;
    }

    private Border getNoFocusBorder() {
    Border border = UIManager.getBorder("List.cellNoFocusBorder");
    if (System.getSecurityManager() != null) {
        if (border != null) return border;
        return SAFE_NO_FOCUS_BORDER;
    } else {
        if (border != null &&
                (noFocusBorder == null ||
                noFocusBorder == DEFAULT_NO_FOCUS_BORDER)) {
            return border;
        }
        return noFocusBorder;
    }
}

    protected void formatBorder(JComponent comp, JList<? extends PatientData> list, int index, boolean isSelected, boolean cellHasFocus) {
        Border border = null;
        if (cellHasFocus) {
            if (isSelected) {
                border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
            }
            if (border == null) {
                border = UIManager.getBorder("List.focusCellHighlightBorder");
            }
        } else {
            border = getNoFocusBorder();
        }
        comp.setBorder(border);
    }

    protected void formatBackground(JComponent comp, JList<? extends PatientData> list, int index, boolean isSelected, boolean cellHasFocus) {
        Color bg = null;

        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            bg = UIManager.getColor("List.dropCellBackground");

            isSelected = true;
        }

        if (isSelected) {
            comp.setBackground(bg == null ? list.getSelectionBackground() : bg);
        } else {
            comp.setBackground(list.getBackground());
        }

        comp.setOpaque(isSelected);

        setEnabled(list.isEnabled());
    }

    protected void formatForeground(Component comp, JList<? extends PatientData> list, int index, boolean isSelected, boolean cellHasFocus) {
        Color fg = null;

        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            fg = UIManager.getColor("List.dropCellForeground");

            isSelected = true;
        }

        if (isSelected) {
            comp.setForeground(fg == null ? list.getSelectionForeground() : fg);
        } else {
            comp.setForeground(list.getForeground());
        }

        comp.setEnabled(list.isEnabled());
        comp.setFont(list.getFont());

    }
}