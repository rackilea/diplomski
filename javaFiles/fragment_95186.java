new SwingWorker<Void,Void>()
        {
        @Override
        protected Void doInBackground() throws Exception 
            {
            AudioHandler1("Theme.wav",false,true);
            return null;
            }
        }.execute();