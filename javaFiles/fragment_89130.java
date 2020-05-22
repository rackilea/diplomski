BufferedReader br = new BufferedReader(new FileReader ("file.txt"));
String str=null;
// I set the counter to zero
int i = 0;
while( (str = br.readLine()) !=null ) {

    String[] s = str.split(":");                   
    jTextField2.setText(s[2]);

    SubPanel panel = (SubPanel) jPanel2.getComponent(i);
    JTextField tf = panel.getTf();
    tf.setText(s[2]);
    System.out.println(s[2]);
    // for each new line we take the next SubPanel
    i++;
}