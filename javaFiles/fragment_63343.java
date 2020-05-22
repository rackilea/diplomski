out.writeObject(messageobject);
out.flush();
System.out.println(1);

messageobject.inquire=true;
messageobject.SetLoginUserInfo("122131","21312","dfsd");
out.writeObject(messageobject);