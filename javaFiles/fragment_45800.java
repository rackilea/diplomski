SpinnerModel model = new SpinnerDateModel(now, null, null, Calendar.MINUTE);
JSpinner spinner = new JSpinner(model) {
    @Override
    public void setEditor(JComponent editor) {
        super.setEditor(editor);
        fireStateChanged();
    }
};