//setting buffer size can improve I/O
   bootstrap.setOption("child.sendBufferSize", 1048576);
   bootstrap.setOption("child.receiveBufferSize", 1048576); 

   // better to have an receive buffer predictor 
   bootstrap.setOption("receiveBufferSizePredictorFactory", new AdaptiveReceiveBufferSizePredictorFactory(MIN_PACKET_SIZE, INITIAL_PACKET_SIZE, MAX_PACKET_SIZE))  

   //if the server is sending 1000 messages per sec, optimum write buffer water marks will
   //prevent unnecessary throttling, Check NioSocketChannelConfig doc   
   bootstrap.setOption("writeBufferLowWaterMark", 32 * 1024);
   bootstrap.setOption("writeBufferHighWaterMark", 64 * 1024);