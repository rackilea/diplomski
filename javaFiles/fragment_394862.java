@Override
public void actionPerformed(ActionEvent e) {
    JDialog dlg = new JDialog(jf, "modal");
    dlg.add(new JLabel("hello"));
    dlg.setModal(true);
    dlg.pack();
    dlg.setLocationRelativeTo(canvas);
    dlg.setVisible(true);
    button.getModel().setRollover(false);
}