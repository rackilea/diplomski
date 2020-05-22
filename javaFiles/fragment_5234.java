public void run() {
            Request r = null;
            try {
                ObjectInputStream inFromClient = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream outToClient = new ObjectOutputStream(s.getOutputStream());
                while (isStarted()) {
                    final Object receivedObject = inFromClient.readObject();
                    // LOGGER.debug("Receiving "
                    // + ((Request) receivedObject).getRequestType() + " "
                    // + receivedObject);
                    r = (Request) receivedObject;
                    processId.set(r.getProcessId());
                    Response rs = new Response();
                    rs.setRequest(r);
                    rs.setServerFrom(GoldenNodeServer.this);
                    if (getOperationBase() != null) {
                        try {
                            Object s = ReflectionUtils.callMethod(getOperationBase(), r.getMethod(), r.getParams());
                            rs.setReturnValue(s);
                        } catch (Exception e) {
                            rs.setReturnValue(e);
                        }
                        outToClient.writeObject(rs);
                    } else {
                        rs.setReturnValue(new NoClientProxySetException());
                    }
                }
            } catch (EOFException e) {
                // LOGGER.trace("eof occured");
            } catch (SocketException e) {
                if (e.toString().contains("Socket closed") || e.toString().contains("Connection reset")
                        || e.toString().contains("Broken pipe")) {
                } else {
                    stop();
                    LOGGER.error("Error occured" + (r == null ? "" : " while processing " + r) + " ", e.toString());
                }
            } catch (IOException | ClassNotFoundException e) {
                stop();
                LOGGER.error("Error occured" + (r == null ? "" : " while processing " + r) + " ", e.toString());
            } finally {
                tcpProcessors.remove(this);
            }
        }