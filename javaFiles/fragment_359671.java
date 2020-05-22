GraphicsDevice deviceObject;
Window windowObject;

try {
    deviceObject.setFullScreenWindow(windowObject);

}catch(Exception e){
  e.printStackTrace();
}finally {
    deviceObject.setFullScreenWindow(null);
}