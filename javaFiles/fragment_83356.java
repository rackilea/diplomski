Handler handler = new Handler();

Runnable spalshRunnable = new Runnable() {
    @Override
    public void run() {
        startActivity(new Intent(YourActivity.class, MainScreen.this));
        finish(); 
    }
}