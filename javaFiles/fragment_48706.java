FileConnection fconn = (FileConnection) Connector.open("file:///SomeDirectory");
Enumeration en = fconn.list();
while (en.hasMoreElements()) {
    String name = en.nextElement();
    FileConnection tmp = (FileConnection) Connector.open(
        "file:///SomeDirectory/" + name);
    tmp.delete();
    tmp.close();
}