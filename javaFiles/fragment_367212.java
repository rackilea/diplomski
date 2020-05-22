new Thread(new Runnable(){
    public void run() {
        JOptionPane.showMessageDialog(null, "message", "Alert!",
                JOptionPane.ERROR_MESSAGE);
    }
}).start();

System.out.println("HI!");