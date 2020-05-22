public class Sandbox {
//    ....
    public final class JPanelEventHandler implements Listener<JPanel> {
        AnotherInterface target;
        JPanelEventHandler(AnotherInterface target){this.target = target;}
        public final void onEvent(JPanel event){
             target.onEvent(event);
        }
    }
///same with JLabel
}