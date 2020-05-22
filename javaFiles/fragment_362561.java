Template t = ve.getTemplate("q44153836.vm");    

VelocityContext context = new VelocityContext();
context.put("InetAddress", java.net.InetAddress.class);

StringWriter writer = new StringWriter();
t.merge(context, writer);