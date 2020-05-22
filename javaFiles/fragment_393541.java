public static void main(String argS[]) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            PVE pv = new PVE();
        }
    });
}