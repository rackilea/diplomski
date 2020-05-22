private ProgressDialog progress;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      progress = new ProgressDialog(this);
   }


   public void open(View view){
      progress.setMessage("Downloading Music :) ");
      progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
      progress.setIndeterminate(true);
      progress.show();

   final int totalProgressTime = 100;

   final Thread t = new Thread(){

   @Override
   public void run(){

      int jumpTime = 0;
      while(jumpTime < totalProgressTime){
         try {
            sleep(200);
            jumpTime += 5;
            progress.setProgress(jumpTime);
         } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
         }

      }

   }
   };
   t.start();
   }