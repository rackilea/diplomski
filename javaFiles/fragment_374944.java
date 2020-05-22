Handler handler = new Handler();
final Runnable r = new Runnable()
{
    public void run() 
    {
        doThis(myVar2);.
    }
};
...
...
handler.postDelayed(r, 1000);