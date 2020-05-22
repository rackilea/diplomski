try {
    System.err.println(Class.forName("org.apache.thrift.transport.TSocket"));
}
catch (Exception e) {
    System.err.println(e);
}