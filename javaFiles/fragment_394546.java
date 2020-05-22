Timer myTimer;
String image[]; // array of imagePath
private int imagePostion;


class MyTimerTask extends TimerTask {

        public void run() {
            try {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            if (++imagePostion == image.length) {
                                imagePostion = 0;
                            }
                             imgView.setImageBitmap(BitmapFactory.decodeFile(image[imagePostion]));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
// change image every 2 seconds
public void startTimerTask() {
        MyTimerTask myTask = new MyTimerTask();
        myTimer = new Timer();
        myTimer.schedule(myTask, 0, 2000);

    }

@Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

                image = {} // fille array with filePath




    }


@Override
    public void onPause() {
        super.onPause();

        try {
            myTimer.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

// start slide show
@Override
    public void onResume() {
        super.onResume();
            startTimerTask(); // start slide show
        }