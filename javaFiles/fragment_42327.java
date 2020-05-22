public static void main(String[] args) throws Exception {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            new NewCalendar();
        }
    });
}