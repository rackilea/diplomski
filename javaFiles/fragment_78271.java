InitialContext ctx = new InitialContext(); // no need to add anything to the context

// A few reminders about the below:
// 1. For multiple hosts, separate with commas, i.e. "corbaname::@<server:port>,:@<server2:port2>"
// 2. If periods are used in the lookup name, they must be escaped, i.e. MyEJBHome-1.0 needs to be MyEJBHome-1\.0
Object obj= ctx.lookup("corbaname::@example.test.com:11000/NameServiceServerRoot#cell/clusters/MyEJBHome12Cluster/MyEJBHome");

// Normal EJB things below
MyEJBHome home = (MyEJBHome) javax.rmi.PortableRemoteObject.narrow(obj, MyEJBHome.class);
MyEJB myEJB = home.create();