import android.app.Activity;
    import android.content.Intent;
    import android.hardware.Camera;
    import android.os.Bundle;
    import android.os.Handler;
    import android.view.View;
    import android.widget.ImageButton;
    import android.widget.SeekBar;
    import android.widget.SeekBar.OnSeekBarChangeListener;

    public class StrobeLightConfig extends Activity {

        boolean check = false;

        Camera sandy;
        StrobeRunner runner;
        Thread bw;
        ImageButton btnClick;

        public final Handler mHandler = new Handler();

        public final Runnable mShowToastRunnable = new Runnable() {
            public void run() {

            }
        };

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            btnClick = (ImageButton) findViewById(R.id.btnSwitch);


            runner = StrobeRunner.getInstance();
            runner.controller = this;

            if (runner.isRunning) {

            } else {
                try {
                    sandy = Camera.open();

                    if (sandy == null) {
                        return;
                    }

                    sandy.release();
                } catch (RuntimeException ex) {
                    return;
                }
            }

            bw = new Thread(runner);
            bw.start();

            btnClick.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (check) {
                        bw = new Thread(runner);
                        bw.start();
                        check = false;
                    } else {
                        check = true;
                        runner.requestStop = true;
                    }            
                }
            });

            final SeekBar skbar = (SeekBar) findViewById(R.id.SeekBar01);
            skbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                        boolean fromUser) {


                    runner.delay = 101 - progress;
                    runner.delayoff = 101 - progress;

                }
            });

        }

        @Override
        protected void onStop() {
    //        runner.requestStop = true;

            super.onStop();
        }

        @Override
        public void onBackPressed() {
            // TODO Auto-generated method stub
    //        super.onBackPressed();

            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);

        }

    }