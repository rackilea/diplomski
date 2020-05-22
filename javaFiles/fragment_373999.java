private void addNewSmtpAccountActionPerformed(java.awt.event.ActionEvent evt) {

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth = gbc.REMAINDER;
    gbc.fill = gbc.HORIZONTAL;
    gbc.weightx = 1;

    ID++;
    smtp_tmp = new SmtpSettings(this, ID);
    //smtp_tmp.setBounds(0, (ID * smtp_tmp.getSize().height)+5, 600, 100);
    lista.add(smtp_tmp, gbc);
    lista.revalidate();

    smtp_list.add(smtp_tmp);

}