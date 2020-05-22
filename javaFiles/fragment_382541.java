int i = 0; //declare this globally
final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        if(i != 10) { 
                text.append(" " + i);
                i++;
                handler.postDelayed(this, 1000);
            }
        }
    }, 1000);
}