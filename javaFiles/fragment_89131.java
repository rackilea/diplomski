BufferedReader br = new BufferedReader(new FileReader ("file.txt"));
String str=null;
// I set the counter to zero
int i = 0;
while( (str = br.readLine()) !=null ) {

    String[] s = str.split(":");
    if(i == 0) {
        // First line of every file would be added to the TextField2 instance                
        jTextField2.setText(s[2]);

    } else {
        // Every additional line would be added to the tf instance
        // we have to substract -1 to i in order to get the first SubPanel
        SubPanel panel = (SubPanel) jPanel2.getComponent(i - 1);
        JTextField tf = panel.getTf();
        tf.setText(s[2]);
    }
    System.out.println(s[2]);
    // for each new line we take the next SubPanel
    i++;
}