JButton jbt1 = new JButton("Button1");
JButton jbt2 = new JButton("Button2");
JButton jbt3 = new JButton("Button3");
JButton jbt4 = new JButton("Button4");

public BoxTest(){
    Box box = Box.createVerticalBox();    // vertical box
    box.add(jbt1);
    box.add(jbt2);
    box.add(jbt3);
    box.add(jbt4);

    add(box);  
}