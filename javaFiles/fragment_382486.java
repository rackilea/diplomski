private boolean sendBase64Credentials(IMAPSClient client) {
    String base64Encoded;

    try {
        // Outlook.com specification
        // user={user@domain.com}^Aauth=Bearer {access token}^A^A
        byte[] binLogin = ("user=" + user + "\u0001auth=Bearer "
                + oauthToken + "\u0001\u0001").getBytes("utf-8");
        base64Encoded = Base64.encodeBase64StringUnChunked(binLogin);
    } catch (UnsupportedEncodingException e) {
        return false;
    }

    try {
        int code = client.sendData(base64Encoded);
        switch (code) {
        case IMAPReply.OK:
            return true;
        case IMAPReply.BAD:
        case IMAPReply.CONT:
        case IMAPReply.NO:
        default:
            System.out.println("return = ?");
        }
        System.out.println(client.getReplyString());

    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}

private boolean authenticateXoauth2(IMAPSClient client) {
    try {
        int code = client.sendCommand("AUTHENTICATE XOAUTH2");
        switch (code) {
        case IMAPReply.CONT:
            return sendBase64Credentials(client);
        case IMAPReply.OK:
        case IMAPReply.BAD:
        case IMAPReply.NO:
        default:
            System.out.println("ERRO");
        }

    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
    return false;
}