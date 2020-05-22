public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            private final JTabbedPane jtp = new JTabbedPane();

            @Override
            public void run() {
                MyTextField textField = new MyTextField();
            }
        });
    }