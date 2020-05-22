public void keyPressed(KeyEvent e) {
    Function f = new Function();
    ResultSet rs = null;
    String ans = "Key";

    rs = f.find(jTextField1.getText());
    try{
        if(rs.next()){
            jTextArea1.setText(rs.getString("Key"));
        }         
    }catch(Exception ex){}
}