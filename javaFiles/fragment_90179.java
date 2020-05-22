protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            cl = (ConstraintLayout) findViewById(R.id.cl);
            cl.setBackgroundResource(R.drawable.bb1);
            i = 0;
            new Timer().scheduleAtFixedRate(new TimerTask() {
              @Override
              public void run() {
                runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                            cl.animate().alpha(0f).setDuration(1500);
                if (i == 0)
                  cl.setBackgroundResource(R.drawable.bb1);
                else if (i == 1)
                  cl.setBackgroundResource(R.drawable.bb2);
                else if (i == 2)
                  cl.setBackgroundResource(R.drawable.bb3);
                else if (i == 3)
                  cl.setBackgroundResource(R.drawable.bb4);
                else if (i == 4)
                  cl.setBackgroundResource(R.drawable.bb5);
                else if (i == 5)
                  cl.setBackgroundResource(R.drawable.bb6);
                i++;
                cl.animate().alpha(1f).setDuration(1500);
                  }
                });

              }
            }, 0, 3000);
          }