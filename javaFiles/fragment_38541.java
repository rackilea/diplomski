public static void insertJndi( ) throws NamingException  {

    DirContext ctx = connectJndi();
    Attributes attributes = new BasicAttributes(); 
    Attribute objectClass = new BasicAttribute("objectClass");
    objectClass.add("anything");
    attributes.put(objectClass);
    Attribute a = new BasicAttribute("a");
    Attribute b = new BasicAttribute("b");
    a.add("jin");
    b.add("lee");
    attributes.put(a);
    attributes.put(b);
    ctx.createSubcontext("cn=a002,ou=b,ou=c,ou=d,o=government of Mars,c=Earth", attributes);
    System.out.println("it worked");