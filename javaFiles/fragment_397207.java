public class MainActivity extends AppCompatActivity implements Runnable {
    private final Handler handler = new Handler();

    @Override
    protected void onResume(){
        super.onResume();
        run();
    }

    @Override
    protected void onPause(){
        handler.removeCallbacks(this);
        super.onPause();
    }

    public void run(){
        fillField(R.id.fieldVoltage, battery.getVolt());
        handler.postDelayed(this, 1000);
    }

    [....]
}