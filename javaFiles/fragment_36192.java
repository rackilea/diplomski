msg=myMessages.get(i); // myMessages is an array of TextMessages 
            qsender = qsession.createSender((Queue)msg.getJMSDestination());
            qreceiver=qsession.createReceiver((Queue)msg.getJMSDestination());

            tempq = qsession.createTemporaryQueue();
            responseConsumer = qsession.createConsumer(tempq);
            msg.setJMSReplyTo(tempq);
            responseConsumer.setMessageListener(new Listener());

            msg.setJMSCorrelationID(msg.getJMSCorrelationID()+i);
            /* MODIFICATIONS */  
            synchronzied(timemap){
               timemap.put(msg.getJMSCorrelationID(), System.currentTimeMillis());
            } /* END MODIFICATIONS */
            qsender.send(msg);