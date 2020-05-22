public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                JFrame window = new JFrame();
                window.setBounds(100, 100, 450, 300);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                window.getContentPane().setLayout(new BorderLayout());
                JobInfoPanel jobInfoPanel = new JobInfoPanel();
                window.getContentPane().add(jobInfoPanel,
                        BorderLayout.CENTER);
                window.pack();
                jobInfoPanel.createDriverListPanel();                   
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}