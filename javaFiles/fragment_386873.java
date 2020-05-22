ServerSocket ss = new ServerSocket(0);
try {
    Assert.assertFalse(PortUtil.isPortAvailable(ss.getLocalPort()));
}
finally {
    ss.close();
}