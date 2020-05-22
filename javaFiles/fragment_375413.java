b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
// Code added
        }
    });
// End of Added code
    b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            t1.setText(""+genericclass.twelveoclockfix + ":" + genericclass.minfixed + " " + genericclass.AMPMtxt);
            System.out.println(t2.getSelectedItem());
            JOptionPane.showMessageDialog(Frame1, "Le 9gag army waz h3r3!");

        }});