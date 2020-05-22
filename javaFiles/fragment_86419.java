public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            window menu = new window();
            menu.ventana();
            menu.actions();
        }
    });
}