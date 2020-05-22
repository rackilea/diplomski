private Response doUnicastTCP(Server remoteServer, Request request) throws ServerException {
                Socket clientSocket = null;
                ObjectOutputStream outToServer = null;
                ObjectInputStream inFromServer = null;
                try {
                    if (isStarted()) {
                        request.setRequestType(RequestType.UNICAST_TCP);
                        // LOGGER.debug("Sending " + request.getRequestType() + " "
                        // + request);
                        clientSocket = new Socket(remoteServer.getHost(), remoteServer.getUnicastTCPPort());
                        clientSocket.setSoTimeout(request.getTimeout());
                        outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
                        inFromServer = new ObjectInputStream(clientSocket.getInputStream());
                        outToServer.writeObject(request);
                        Response response = (Response) inFromServer.readObject();
                        // LOGGER.debug("Received " + request.getRequestType() + " "
                        // + response);
                        if (response.getReturnValue() instanceof Exception) {
                            throw new ServerException((Exception) response.getReturnValue());
                        }
                        return response;
                    } else {
                        throw new ServerNotStartedException();
                    }
                } catch (SocketTimeoutException e) {
                    throw new ServerException("cant execute request " + request + " on server " + remoteServer + " "
                            + e.toString());
                } catch (ClassNotFoundException | IOException e) {
                    throw new ServerException("cant execute request " + request + " on server " + remoteServer + " "
                            + e.toString());
                } finally {
                    try {
                        if (clientSocket != null) {
                            clientSocket.close();
                        }
                    } catch (IOException e) { //
                        LOGGER.trace("socket couldn't be closed");
                    }
                }
            }