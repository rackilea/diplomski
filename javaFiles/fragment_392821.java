public void keyPressed(KeyEvent e) { // not keyTyped!
    if (e.getKeyCode() != KeyEvent.VK_ENTER) {
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
    }
}