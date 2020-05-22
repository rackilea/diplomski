public Test() {
    //canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    canvas.addWindowListener(new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("\nClosing it.");
            try {
                //if (grabber != null)
                        grabber.release();
                        //grabber.stop();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            System.exit(0);
        }
    });
}