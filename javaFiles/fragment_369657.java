public void run() {
    Thread myThread = Thread.currentThread();
    while (Timer_Thread == myThread) {
        switch (Format) {
        case 1:
            Time_Text = Timer.Get_Duration_Hour_Minute_Second();
            break;
        }

        // again this is dangerous code **********
        setText(Time_Text);
        paintImmediately(0, 0, getWidth(), getHeight());
        // ....