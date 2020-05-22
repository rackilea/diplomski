// @todo: scan for devices
    // @todo: for each device search obex push service
    String deviceObexUrl = serviceRecords[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);

    // send file
    ClientSession clientSession = (ClientSession) Connector.open(deviceObexUrl);
    HeaderSet hsConnectReply = clientSession.connect(null);
    if (hsConnectReply.getResponseCode() != ResponseCodes.OBEX_HTTP_OK) {
        return false;
    }

    byte data[] = readAllFile(file);

    HeaderSet headerSet = clientSession.createHeaderSet();
    headerSet.setHeader(HeaderSet.NAME, file.getName());
    headerSet.setHeader(HeaderSet.TYPE, mimeType);
    headerSet.setHeader(HeaderSet.LENGTH, new Long(data.length));
    Operation op = clientSession.put(headerSet);

    OutputStream outputStream = op.openOutputStream();
    // @todo: write all data and close outputStream, op and clientSession