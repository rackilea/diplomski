// Default constructor.
public Scheduler()throws SchedulerException, Exception
{

        try 
        {

            SchedulerFactory sf = new StdSchedulerFactory();
            sche = sf.getScheduler();
            sche.start();

            if(sche.isShutdown())
            {
                SendAlerts.sendMsgToGroup("Scheduler Failed To Start at "+sdtf3.format(new Date())+" hrs.",defaultMsgGroup);
                logger.fatal("Scheduler Failed To Start At = " + sdtf1.format(new Date()) );
            }
            else
            {
                        SendAlerts.sendMsgToGroup("Scheduler started at "+sdtf3.format(new Date())+" hrs.",SchStartAlertGroup);
                        logger.fatal("Scheduler Started At = " + sdtf1.format(new Date()) );
            }
            sysdate =   new Date();
            readFromDBAndConfigureSchedules();
            while (true)
            {
                if(sche.isShutdown())
                {
                        SendAlerts.sendMsgToGroup("Scheduler Failed To Start at "+sdtf3.format(new Date())+" hrs.",defaultMsgGroup);
                        logger.fatal("Scheduler Failed To Start At = " + sdtf1.format(new Date()) );
                }
                else
                {
                        logger.info("Scheduler is Running. Table Last Pinged at :  "+sdtf1.format(sysdate));
                }

                /*
                -----------------
                IN THE CHECK DB TABLE METHOD, HANDLE REQUESTS FOR STOP, PAUSE, RE-SCHEDULE ETC 
                ------------------
                */
                SchRunJob.checkDBTable();

                // Loop will repeat every 1 hour = 60 minutes * 60 seconds = 3600 seconds
                Thread.sleep (3600 * 1000);

            } // End of while Start Flag is Y

        } // End of try block
        catch (Exception e) 
        {
            SendAlerts.sendMsgToGroup( "Fatal Exception Caught.Scheduler Shut Down at " + sdtf1.format(new Date()),defaultMsgGroup);
            logger.fatal("Fatal Exception Caught.Scheduler Shut Down at " + sdtf1.format(new Date()));
            e.printStackTrace();
            System.exit(0);
        }
} // End of default constructor**