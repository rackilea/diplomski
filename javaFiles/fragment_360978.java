public Runnable NameOfRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            while (true)
            {
            // TODO add code to refresh in background
                try
                {

                    Thread.sleep(1000);// sleeps 1 second
                    //Do Your process here.
                } catch (InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        }

    }
};