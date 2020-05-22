if(key == KeyEvent.VK_SPACE && papi.isAlive() != true){ 
    remove(papi);
    papi = new PAPITest();
    papig = new PAPIGame();
    papi.setSize(600,600);
    add(papi);
    setVisible(true);
    repaint();
}