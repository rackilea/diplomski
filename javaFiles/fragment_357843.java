public static void main(String[] args)
     {

        SwingUtilities.invokeLater(new Runnable() {

        public void run() {
            MnemonicEx1 ex = new MnemonicEx1();
            ex.setVisible(true);
        }
        });

        SwingUtilities.invokeLater(new Runnable() {

        public void run()
        {
            MnemonicEx1 ex = new MnemonicEx1();
            ex.setVisible(true);
        }
    });

}