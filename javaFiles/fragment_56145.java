public class MyTextArea extends JScrollPanel{   

    public JTextArea ta = new JTextArea();

    public MyTextArea(){
        ta.setEditable(true);
        ta.setSize(500, 500);
        setViewPortView(ta);
    }
}