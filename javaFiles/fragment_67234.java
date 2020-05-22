String header = "nChat v1.0";
//INBOUND 
pipeline.addLast(new LengthFieldBasedFrameDecoder(1024,0,2,0,2));
pipeline.addLast(new HeaderFieldDecoder(header));
pipeline.addLast(new StringDecoder());

//OUTBOUND
pipeline.addLast(new LengthFieldPrepender(2)); 
pipeline.addLast(new HeaderFieldEncoder(header));
pipeline.addLast(new StringEncoder());