@Override
public void run() {
   buttons[randomOrder.get(counter[0])].setAlpha(1.0f);
   counter[0]++;
   if (counter[0] == generatedSquares)
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                enableAllButtons(true);
            }
        });
        timer.cancel();
    }
}