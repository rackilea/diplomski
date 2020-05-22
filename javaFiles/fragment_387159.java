public Map<Integer, Long> keyPressMap = new HashMap<>();

 public void keyPressed(KeyEvent arg0) {
    keyPressMap.put(arg0.getKeyCode(), System.currentTimeMillis());
 }

 public void keyReleased(KeyEvent arg0) {
    keyPressMap.remove(arg0.getKeyCode());
 }

 // find out if key is pressed and how long it was
 Long t = keyPressMap.get(KeyEvent.VK_SPACE);
 if (t == null) {
     // not pressed
 } else {
     // pressed for X milliseconds
     long millis = t - System.currentTimeMillis();
 }