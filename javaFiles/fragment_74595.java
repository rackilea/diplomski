...
Properties props = new Properties();
props.add("org.omg.CORBA.ORBInitialHost", httpServletRequest.getParameter("initialHost"));
props.add("org.omg.CORBA.ORBInitialPort", httpServletRequest.getParameter("initialPort"));
ORB orb = ORB.init(null, props);
// do some work with your ORB
...