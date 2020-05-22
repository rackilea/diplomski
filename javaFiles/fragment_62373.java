for (int i = 0; i < 9; i++) {
    final int tmpI = i;
    JLabel jl = new JLabel(String.valueOf(i));
    jl.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {

                    addAnEventToLabel(tmpI);
        }
    });
}