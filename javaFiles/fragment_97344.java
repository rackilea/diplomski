String code = "VK_" + ch    
Field f = KeyEvent.class.getField(code);
int keyEvent = f.getInt(null);

robot.press(keyEvent);
robot.release(keyEvent);