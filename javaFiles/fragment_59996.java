if (RadioInfo.getState() == RadioInfo.STATE_OFF) {
        if (Dialog.ask(Dialog.D_YES_NO, "You currently have no network connection\nDo you want to turn connections on?", Dialog.YES) == Dialog.YES)
        {
            //Activate GPRS
            Radio.activateWAFs(RadioInfo.WAF_3GPP);

            //Sleep for 10secs to allow wireless to activate. 
            // TODO (DG) DO THIS IN NEW THREAD TO PREVENT BLOCKING UI THREAD
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        } }