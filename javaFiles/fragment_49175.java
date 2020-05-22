public void SetStyleForTextAreaLabel( JTextArea ta) {
    ta.setEditable( false);
    ta.setLineWrap( true);
    ta.setWrapStyleWord( true);
    ta.setDisabledTextColor( Color.black);
    ta.setBackground( this.getBackground());
}