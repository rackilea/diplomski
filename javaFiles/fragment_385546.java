AID r=new AID("agent-name@platform",AID.ISGUID);
r.addAddresses("http://192.168.1.1:7778/acc");
acl.addReceiver(r);
acl.setContent("Hello.!");
this.send(acl);
System.out.println("\nMessage Sent to "+r);