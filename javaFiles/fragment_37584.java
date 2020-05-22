public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    //Class value conversion to getString value using getter

    if (value instanceof SchoolYear) {
        this.setText("" + ((SchoolYear) value).getStart());
    } else if (value instanceof GradeLevel) {
        this.setText("" + ((GradeLevel) value).getGradelevel());
    } else if (value instanceof PaymentTerm) {
        this.setText("" + ((PaymentTerm) value).getPaymentTerm());
    } else if (value instanceof FeeCategory) {
        this.setText("" + ((FeeCategory) value).getFeeCategory());
    } else {
        this.setText("---");
    }

    //selection formatting
    if (isSelected) {
        this.setBackground(Color.YELLOW);
        //this.setBackground(list.getSelectionBackground());
        this.setForeground(list.getSelectionForeground());
    } else {
        this.setBackground(list.getBackground());
        this.setForeground(list.getForeground());

    }

    if ((isSelected) && (cellHasFocus)) {
        this.setBorder(new LineBorder(Color.black));
    } else {
        this.setBorder(null);
    }
    return this;
}