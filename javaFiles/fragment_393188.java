JScrollPane scroll; //-->> somewhere in your class
public void lyricPrinter(){

    System.out.println(lyrics);
    JTextArea textarea = new JTextArea(lyrics);
    textarea.setBackground(Color.LIGHT_GRAY);
    textarea.setEditable(false);
//JLabel textarea = new JLabel("not sure what this is...");
//textarea.setText("<html>"+lyrics+"</html>");

 **scroll = new JScrollPane (textarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
scroll.removeAll();**


//GUI.frame.remove(scroll);
GUI.frame.add(scroll);
GUI.frame.setVisible(true);