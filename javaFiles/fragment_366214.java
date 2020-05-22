JOptionPane.showConfirmDialog(null,
                        getCustomPanel(), // this will return a Panel design on your Own
                        "JOptionPane Example : ",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
//and your Custom Panel
 private JPanel getCustomPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Text Message:");
        panel.setLayout(null);
        JButton okbtn=new JButton("ok");
        label.setBounds(10,20,200,40); //x,y,width,height
        okbtn.setBounds(220,20,80,40); //x,y,width,height
        panel.add(label);
        panel.add(okbtn);
        return panel;
    }