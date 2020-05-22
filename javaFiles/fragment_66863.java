private static JButton createButton(String text, final int s) {
    JButton b = new JButton(text){
        @Override
        public void setLocation(int x, int y) {
            super.setLocation(x-(s*4), y);
        }
    };
    return b;
}