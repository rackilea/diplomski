public static void main(String [] args) throws Exception{
    Runnable t = new Runnable(){
        public void run(){
            new AWTCounter();
        }
    };
    SwingUtilities.invokeAndWait(t);
}