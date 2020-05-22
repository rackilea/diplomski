try {
    MaskFormatter mf = new MaskFormatter("***.***.***.***");
    JFormattedTextField txtIP = new JFormattedTextField(mf);
    panIP.add(txtIP);
    txtIP.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    txtIP.setPreferredSize( new Dimension( 150, 24 )); 
} catch (ParseException pe) {
    e.printStackTrace();
}