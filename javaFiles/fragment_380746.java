public class Main extends Activity {

    public int color1, color2, red1, red2, blue1, blue2, green1, green2;

    View v;

    ObjectAnimator anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        // White or whatever color background R.id.view
        // has at the beginning
        color1 = 0xffffffff;

        v = findViewById(R.id.llMain);

        // We haven't initialized color2 yet. Will set this later
        anim = ObjectAnimator.ofInt(v, "backgroundColor", color1);

        anim.setEvaluator(new ArgbEvaluator());

        anim.setDuration(3000);


        new Thread() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Main.this.runOnUiThread(new Runnable() {
                        public void run() {

                            //generate color 2

                            red2 = (int)(Math.random() * 128 + 127);
                            green2 = (int)(Math.random() * 128 + 127);
                            blue2 = (int)(Math.random() * 128 + 127);
                            color2 = 0xff << 24 | (red2 << 16) |
                                    (green2 << 8) | blue2;

                            // Update the color values
                            anim.setIntValues(color1, color2);

                            anim.start();

                            // Order the colors
                            color1 = color2;

                        }
                    });
                }
            }
        }.start();
    }
}