txtOutput.addVerifyListener(new VerifyListener() {
        public void verifyText(VerifyEvent e)
        {
            if( !endingThreads )
            {
                e.doit = true;
            }
            else
            {
                e.doit = false;
            }
        }
    });