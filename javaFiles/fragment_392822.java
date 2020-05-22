public void keyTyped(KeyEvent e) {
    if (e.getKeyChar() != 13 && e.getKeyChar() != 10) {
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
    }
}