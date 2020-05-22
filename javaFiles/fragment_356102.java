public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            EliminationGame g1 = new EliminationGame();
        }
    });
}