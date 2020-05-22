private boolean isclick;
Handler handler ; 
private TextView start;
private boolean isClicked;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        start = (TextView) findViewById(R.id.tvStart);
        handler = new Handler();

        isclick = false;
        new Thread(new Runnable() {

            @Override
            public void run() {
                 while (isclick == false)
                    {
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        Random r = new Random();



                            start.setTextSize(r.nextInt(50));
                            start.setTextColor(Color.rgb(r.nextInt(256), r.nextInt(256),
                                    r.nextInt(256)));

                        }

                    });
                     Log.w("DEBUG","Text View  value : "+ start.getText().toString());

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                }


            }
        }).start();



    }