class MainActivity extends Activity
{
    //...
    private static boolean perform;

    private static getPerform()
    {
        return perform;
    }

    public void onClick (View v){
        switch(v.getId()) {
            case R.id.button1:
                perform = true;

                Thread t = new SpeakThread();
                t.start();

                break;

            case R.id.button2:
                perform = false;
                break;
        }
    }
}

class SpeakThread extends Thread
{
    public void run()
    {
        while(MainActivity.getPerform())
        {
            speak();
        }
    }
}