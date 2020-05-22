// graph is final so it may be used in an inner class
public ControlsB(Box box2, final Graph graph) {

     // .....

      btn1.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent event){

            f = Integer.parseInt(f1.getText());
            g = Integer.parseInt(f2.getText());
            System.out.println(f + "  " + g);

            // invalidate();
            // validate();
            //  paint(p); ***** NEVER do this

            graph.repaint();
        }
    });
}