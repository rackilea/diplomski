private InputStream in;
    @Override
        public void interrupt() {
            super.interrupt();
            try {
                in.close(); 
            } catch (IOException e) {}
        }