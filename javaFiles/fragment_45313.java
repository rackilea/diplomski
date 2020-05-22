private  JTextField dis(JFileChooser jf) {
    boolean hide =false;
    LinkedList<Component> queue = new LinkedList<Component>();
    queue.add(jf);
    JTextField jtf=new JTextField();
    while(queue.size() != 0) {
        Component[] c = ((Container) queue.removeFirst()).getComponents();   
        for(int i = 0; i < c.length; i++) {                        
            queue.add(c[i]);    

            if(c[i] instanceof JTextField) {
                jtf = (JTextField) c[i];
                jtf.setVisible(true);
                jtf.setEnabled(true);
                jtf.setText(" hello ");
                return jtf;
            }


    }           
}


return jtf;