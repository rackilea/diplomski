String message1 = url;
OutboundMessage msg = new OutboundMessage("mygroup", message1);
Service.getInstance().sendMessage(msg);
System.out.println(msg);
Service.getInstance().stopService(); 
Service.getInstance().removeGateway(gateway);//remove the gateway