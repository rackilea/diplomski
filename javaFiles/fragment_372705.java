public void start_my_timer()
{

    Screen_Timer_Task = new TimerTask() {

        @Override
        public void run() {


                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                                // Do my stuff
                    }
                });

        }

    };

    Screen_Timer.schedule(Screen_Timer_Task, 1, 1);

}