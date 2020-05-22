public void myBlink()
{
    new Timer(1000, new ActionListener() {
        boolean visible = true;
        public void actionPerformed(ActionEvent e) {
            jLabel8.setVisible(visible = !visible);
        }
    }).start();
}