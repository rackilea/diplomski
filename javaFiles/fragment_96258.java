private void open()
throws IOException
{
Display.setAppName("Android Projector");
Display localDisplay = new Display();
final Shell localShell = new Shell(localDisplay);
localShell.setText("Device Screen");
localShell.setSize(width,height);
//localShell.setLocation(300, 300);
createContents(localShell);
localShell.addShellListener(new ShellListener() {

    public void shellIconified(ShellEvent e) {
    }
    public void shellDeiconified(ShellEvent e) {
    }
    public void shellDeactivated(ShellEvent e) {
    }
    public void shellClosed(ShellEvent e) {
        System.out.println("Client Area: " + localShell.getClientArea());
    }
    public void shellActivated(ShellEvent e) {
        int frameX = localShell.getSize().x - localShell.getClientArea().width;
        int frameY = localShell.getSize().y - localShell.getClientArea().height;
        if (AndroidProjector.this.mRotateImage) { 
            localShell.setSize(height * percentSize/100 + frameX, width * percentSize/100 + frameY);
        }
        else { 
            localShell.setSize(width * percentSize/100 + frameY,height * percentSize/100); 
        }
    }
});     
localShell.open();
SocketChannel localSocketChannel = null;
try
{
  while (!localShell.isDisposed()) {
    if (!localDisplay.readAndDispatch())
    {
      localSocketChannel = connectAdbDevice();
      if (localSocketChannel == null) {
        break;
      }
      if (startFramebufferRequest(localSocketChannel))
      {
        int frameX = localShell.getSize().x - localShell.getClientArea().width;
        int frameY = localShell.getSize().y - localShell.getClientArea().height;
        getFramebufferData(localSocketChannel);
        updateDeviceImage(localShell, this.mRotateImage ? this.mRawImage.getRotated() : this.mRawImage);
        if (this.mRotateImage) { 
            localShell.setSize(height * percentSize/100 + frameX, width * percentSize/100 + frameY);
        }
        else { 
            localShell.setSize(width * percentSize/100 + frameX, height * percentSize/100 + frameY);
        }
      }
      localSocketChannel.close();
    }
  }
}
finally
{
  if (localSocketChannel != null) {
    localSocketChannel.close();
  }
  localDisplay.dispose();
}
}