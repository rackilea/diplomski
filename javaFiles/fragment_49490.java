private SnmpSession session;

/**
* Create a listener for trap version 1-2 
*/
        public void trapsListener ()
        {
            logger.debug(".in");

            SnmpAPI api = new SnmpAPI();
    //      api.setDebug( true );
            session = new SnmpSession(api);
            session.addSnmpClient(this);
            UDPProtocolOptions udpOpt = new UDPProtocolOptions();
            udpOpt.setLocalPort(TRAP_PORT);
            session.setProtocolOptions(udpOpt);
            try
            {
                session.open();
                String message="Succes to bind port: "+session.getLocalPort();
                logger.info(message);
                System.out.println(message);
            }
            catch (Exception ex)
            {
                String message = "Failed to open session - Port in use or permission denied. \n Message-  "+ ex.getMessage() + "\n Will exit from Trap process. ";
                logger.error(message, ex);
                System.err.println(message);
                throw new RuntimeException(message);
            }   
        }


/**
* For each new device
* 1) discover the snmp engineID 
* 2) create SnmpEngineEntry and add it to SnmpEngineTable
* 3) create USMUserEntry  and add it to USMUserTable 
* 4) performs time synchronization
**/
    private void initV3Parameters(Device data) throws InterruptedException
    {
        logger.debug("in.");
        try
        {
            UDPProtocolOptions udpOptions = new UDPProtocolOptions();
            udpOptions.setLocalPort(TRAP_PORT);
            udpOptions.setRemoteHost(data.getIpAddress());

            USMUtils.init_v3_parameters(
                    data.getUsmUser(),
                    null,// null means that the SNMPv3 discovery will be activated
                    Integer.valueOf(data.getAuthProtocol()),
                    data.getAuthPassword(),
                    data.getPrivPassword(),
                    udpOptions,
                    session,
                    false,
                    Integer.valueOf(data.getPrivProtocol()));
            printToLog("secsses",data);
        }
        catch (SnmpException exp) {
            logger.error(exp.getMessage()+" for ip = "+data.getIpAddress(),exp);
            printToLog("failed",data);
        }

    }