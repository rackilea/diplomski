private Handler viewHandler;

public void onCreate(Bundle savedInstanceState) {
   ...
   viewHandler = new Handler();
   ...

...

public void onUtteranceCompleted(String uttId) {
    Runnable run = new Runnable() {
        public void run() {
            txtCurrentWord.setText("hello world");
        }
    };
    viewHandler.post(run);
}