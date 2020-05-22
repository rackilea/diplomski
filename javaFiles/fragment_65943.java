public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(new B());
            frame.pack();
            frame.setVisible(true);
        }
    });
}

class B extends JPanel {

    public B() {
        initComponents();
    }

    private void initComponents(){...}
}