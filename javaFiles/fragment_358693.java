String packageName="javax.mail.internet.";
    String simpleClassName="MimeMultipart";
    String className=packageName+simpleClassName;
    Class<?> cl=Class.forName(className);
    URL url=cl.getResource(simpleClassName+".class");
    System.out.println("url="+url);