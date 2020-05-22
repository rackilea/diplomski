private Runnable pingRunnable(final InetAddress address, CountDownLatch waitFor, CountDownLatch clearWhenDone) {
    return new Runnable() {
        public void run() {
            try {

                Socket socket = new Socket(address, SMB_PORT);

                waitFor.await();  // wait for all previous runners to log their output

                LOG.CONSOLE.debug("Connection: " + socket.toString());

                if (socket.isConnected()) {
                    LOG.CONSOLE.debug("connected " + address.toString());

                    String ipString = address.toString().substring(1,
                            address.toString().length());
                    NbtAddress[] addr = NbtAddress
                            .getAllByAddress(ipString);

                    String NETNAME = addr[0].firstCalledName();

                    // String NETNAME1 =
                    // addr[0].nextCalledName();
                    smbNames.add(NETNAME);

                    LOG.CONSOLE.debug("NETNAME " + NETNAME);

                    LOG.CONSOLE.debug("addr " + addr);

                    foundDevicesArray.add(address.toString());
                    LOG.CONSOLE.debug("hostname added to found "
                            + address.toString());

                    socket.close();

                }

                socket.close();
            } catch (UnknownHostException e) {
                // LOG.CONSOLE.debug("Not found", e);
            } catch (IOException e) {
                // LOG.CONSOLE.debug("IO Error", e);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            } finally {
                clearWhenDone.countDown();  // signal to the next Runnable that we are done
            }

        }
    };
}