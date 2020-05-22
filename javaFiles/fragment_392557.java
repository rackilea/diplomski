public void onException (JMSException jsme)
    {
        if (!closeRequested)
        {
            this.disconnect();
            this.establishConnection(connectionProps, queueName, uname, pword, clientID, messageSelector);
        }        
        else
        {
            //Client requested close so do not try to reconnect
        }
    }