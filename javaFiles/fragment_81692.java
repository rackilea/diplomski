static Frame frm = new Frame("Action Event");
static Checkbox ckb1 = new Checkbox("Delivery");
static Button btn = new Button("Calculate");
static TextField textfield1 = new TextField();
static TextField textfield2 = new TextField();
static TextField textfield3 = new TextField();
static TextField textfield4 = new TextField();
static TextField textfield5 = new TextField();

public static void main(String[] args) {
    // TODO Auto-generated method stub



    GridLayout grid = new GridLayout (7,3);
    btn.addActionListener(new ActListener());
    frm.setLayout(grid);
    frm.setSize(400,200);
    frm.setBackground(Color.pink);


    Label lab1 = new Label ("Tea Series");
    Font font1 = new Font(null,Font.BOLD,12);
    lab1.setFont(font1);
    frm.add(lab1);
    frm.add(new Label(""));
    frm.add(new Label(""));


    frm.add(new Label("Black Tea"));
    frm.add(new Label("$70"));
    frm.add(textfield1);


    frm.add(new Label("Green Tea"));
    frm.add(new Label("$70"));
    frm.add(textfield2);

    Label lab2 = new Label ("Special Flavor Series");
    lab2.setFont(font1);
    frm.add(lab2);
    frm.add(new Label(""));
    frm.add(new Label(""));


    frm.add(new Label("Alpine Tea"));
    frm.add(new Label("$80"));
    frm.add(textfield3);


    frm.add(new Label("Stewed Oolong Tea"));
    frm.add(new Label("$80"));
    frm.add(textfield4);


    frm.add(btn);
    frm.add(ckb1);


    frm.add(textfield5);
    frm.addWindowListener(new WindowAdapter()
    { 
          public void windowClosing (WindowEvent Event) {
          System.exit (0);
         } 
        } 
        );


    frm.setVisible(true);
}


static class ActListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(textfield1.getText().toString());
        int b = Integer.parseInt(textfield2.getText().toString());
        int c = Integer.parseInt(textfield3.getText().toString());
        int d = Integer.parseInt(textfield4.getText().toString());

        if (ckb1.getState()){
            int res=((a+b)*70+(c+b)*80)+30;
            textfield5.setText(String.valueOf(res));
        }
        else {
            int res=((a+b)*70+(c+b)*80);
        textfield5.setText(String.valueOf(res));
        }
            }


}