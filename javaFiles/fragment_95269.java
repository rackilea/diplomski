void setJInternalFrame() {
     String htmlContent = "<html><body><table border ='1' bgcolor='#EEEEEE'>"
                + "<tr><td>Hai</td></tr></table></body></html>";

     JInternalFrame jn = new JInternalFrame("I want jlabel here", true, true, true);

     JComponent titleBar = ((BasicInternalFrameUI) jn.getUI()).getNorthPane();

     JLabel label = new JLabel();
     label.setText(htmlContent);
     label.setBounds(128, 0, 40, 20);
     titleBar.add(label);

     jn.setLayout(new FlowLayout());
     jn.add(new JButton("JButton"));
     jn.setVisible(true);
     add(jn);
}