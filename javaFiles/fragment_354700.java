class MyDispatcher implements KeyEventDispatcher {
ArrayList<String>typedKeys = new ArrayList<String>();
public boolean dispatchKeyEvent(KeyEvent e) {

if (e.getID() == KeyEvent.KEY_PRESSED) 
    typedKeys.add(""+e.getKeyChar());

if (e.getID() == KeyEvent.KEY_RELEASED) {
    String str = typedKeys+"";
    System.out.println(str.substring(1,str.length()-1).replaceAll(", ",""));
    typedKeys.clear();
 } 

return false;
}

}