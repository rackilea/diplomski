// Create a variable holding the listener
KeyAdapter keyAdapter = new KeyAdapter()
{
  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      setPosX(getPlayPanelWidth() / 2);
      setPosY(0);

      move = true;
      scorePanel.showPressSpace(false);
      initBall(g2);
    }

  }
};
// Register the listener with this JPanel
addKeyListener(keyAdapter);

// Time passes...

// Remove the listener from this JPanel
removeKeyListener(keyAdapter);