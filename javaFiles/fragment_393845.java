public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            Pan frame = new Pan();
            ...
            frame.setVisible(true);

        }
    });

}