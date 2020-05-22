public void run()
    {
        if(m_bRunning)
        {
            new Thread(){ //Thread to release screen
                @Override
                public void run() {
                    JuliaSet.this.handleCalculation();
                }
            }.start(); //also thread must be started
        }
    }