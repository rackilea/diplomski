private void threadMethod() {
    Display.getDefault().asyncExec(new Runnable() {
        public void run() {
            // threadMethod contents
        }
    });
}