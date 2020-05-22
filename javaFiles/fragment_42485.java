MessageChannel channel = context.getBean("in", MessageChannel.class);
MessagingTemplate template = new MessagingTemplate(channel);
String reply = template.convertSendAndReceive("foo", String.class);
System.out.println(reply);
reply = template.convertSendAndReceive("bar", String.class);
System.out.println(reply);  }