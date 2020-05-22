package com.example.gkvxm.materiallight;

    import android.animation.ValueAnimator;
    import android.app.Activity;
    import android.content.Context;
    import android.content.pm.PackageManager;
    import android.hardware.Camera;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.KeyEvent;
    import android.view.SurfaceHolder;
    import android.view.SurfaceView;
    import android.view.View;
    import android.view.animation.AccelerateDecelerateInterpolator;
    import android.widget.Toast;

    import com.dd.CircularProgressButton;

    import java.io.IOException;


    public class FlashLightActivity extends Activity implements SurfaceHolder.Callback {

        private boolean isLigtOn = false;

        private Camera camera;

        @Override
        protected void onStart(){
            super.onStart();
             camera = Camera.open();
        final Camera.Parameters p = camera.getParameters();
            SurfaceView preview = (SurfaceView)findViewById(R.id.PREVIEW);
                SurfaceHolder mHolder = preview.getHolder();
            mHolder.addCallback(this);
        }

        @Override
        protected void onStop(){
            super.onStop();

            if(camera!=null){
                camera.release();
            }
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_flash_light);

            Context context = this;
            PackageManager pm = context.getPackageManager();

            if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                Toast.makeText(FlashLightActivity.this, "Your Device is not supported", Toast.LENGTH_SHORT).show();
                Log.e("err", "Device is not supported");
                return;
            }

            camera = Camera.open();
            final Camera.Parameters p = camera.getParameters();


            final CircularProgressButton circularButton1 = (CircularProgressButton) findViewById(R.id.btnWithText);
           circularButton1.setIndeterminateProgressMode(true);
            circularButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isLigtOn) {
                        turnOffFlash(p);
                        Toast.makeText(FlashLightActivity.this, "Lights Off!", Toast.LENGTH_SHORT).show();

                    } else {
                        turnOnFlash(p);
                        Toast.makeText(FlashLightActivity.this, "Lights On!", Toast.LENGTH_SHORT).show();

                    }

                    if (circularButton1.getProgress() == 0) {
                        simulateSuccessProgress(circularButton1);
                    } else {
                        circularButton1.setProgress(0);
                    }
                }
            });
        }

        private void turnOnFlash(Camera.Parameters p){
            p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

            camera.setParameters(p);
            camera.startPreview();
            isLigtOn = true;
        }
        private void turnOffFlash(Camera.Parameters p){
            p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(p);
            camera.stopPreview();
            isLigtOn = false;
        }
        @Override
        public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){

        }
        @Override
        public void surfaceCreated(SurfaceHolder holder){
            try{
                Log.i("SurfaceHolder","Setting preview");
                camera.setPreviewDisplay(holder);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder){
            Log.i("SurfaceHOlder", "stopping preview");
            camera.stopPreview();
            holder = null;
        }

        private void simulateSuccessProgress(final CircularProgressButton button) {
            ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 100);
            widthAnimation.setDuration(1500);
            widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animation.getAnimatedValue();
                    button.setProgress(value);
                }
            });
            widthAnimation.start();
        }

        private void simulateErrorProgress(final CircularProgressButton button) {
            ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 99);
            widthAnimation.setDuration(1500);
            widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animation.getAnimatedValue();
                    button.setProgress(value);
                    if (value == 99) {
                        button.setProgress(-1);
                    }
                }
            });
            widthAnimation.start();
        }


    }