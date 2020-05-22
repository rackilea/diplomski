public class SecondActivity extends Activity implements MyEventListener {

    @Override
    public void onResume(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventProducer.instance().register(this);
    }

    @Override
    public void onPause(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventProducer.instance().unregister(this);
    }

    void testMethod(){
        //just doit
    }

    @Override
    void onMyEventCome() {
        testMethod();
    }
}