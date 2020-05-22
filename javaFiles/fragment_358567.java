public static void main (String args[]) throws InvocationTargetException, InterruptedException {

    SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
            newAccount customerObj;
            customerObj = new newAccount();
            bankFrame = new JFrame("Bank account");

            bankFrame.setSize(300, 300);
            bankFrame.setVisible(true);

            customerObj.newAccount();
            bankFrame.getContentPane().add(panelObject);
        }
    });

}