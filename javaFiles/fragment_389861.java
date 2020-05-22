public void init () {
    Container content_pane = getContentPane ();
    content_pane.setLayout (new FlowLayout ());     

    JLabel lblHourWork = new JLabel("Hours Worked");
    // JTextField txtHourWork = new JTextField(10);
    JLabel lblHourRate = new JLabel("Pay Rate");
    // JTextField txtHourRate = new JTextField(10);

    txtHourWork = new JTextField(10);
    txtHourRate = new JTextField(10);