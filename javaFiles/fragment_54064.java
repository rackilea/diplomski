public class TestApplication extends Application {
    public Encapsulation tempClass;
    public TestApplication () {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate() { 
        // TODO Auto-generated method stub
        super.onCreate();
    }

    public Encapsulation getTempClass() {
        return tempClass;
    }

    public void setTempClass(Encapsulation tempClass) {
        this.tempClass  = tempClass;
    }
}