public class Midlet extends DiceMidlet {
    public Midlet() {
        super();
    }
    public void startApp() {
        for(int i=0;i<1000;i++){
            if(i==999){
                super.startApp();
            }
        }

    }
    public void pauseApp() {
        super.pauseApp();
    }
    public void destroyApp(boolean unconditional) {
        super.destroyApp(unconditional);
    }
 }