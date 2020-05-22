public static void main(String [] args) throws Exception{
    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            System.out.println("The document is available");
        }
    };
    Timer timer = new Timer(1000 ,taskPerformer);
    timer.setRepeats(true);
    timer.start();

    JFrame frm = new JFrame();
    frm.setVisible(true);
    frm.setVisible(false);
}