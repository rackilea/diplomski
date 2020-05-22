// We found an opening stream. Record information about it, then notify
// the connectionID lock so that the packet reader startup can finish.
else if (parser.getName().equals("stream")) {
    // Ensure the correct jabber:client namespace is being used.
    if ("jabber:client".equals(parser.getNamespace(null))) {
        // Get the connection id.
        boolean connectionIdReceived = false;
        for (int i=0; i<parser.getAttributeCount(); i++) {
            if (parser.getAttributeName(i).equals("id")) {
                // Save the connectionID
                connectionID = parser.getAttributeValue(i);
                if (!"1.0".equals(parser.getAttributeValue("", "version"))) {
                    // Notify that a stream has been opened if the
                    // server is not XMPP 1.0 compliant otherwise make the
                    // notification after TLS has been negotiated or if TLS
                    // is not supported
                    releaseConnectionIDLock();
                }
                connectionIdReceived = true;
            }
            else if (parser.getAttributeName(i).equals("from")) {
                // Use the server name that the server says that it is.
                connection.config.setServiceName(parser.getAttributeValue(i));
            }
        }
        if (!connectionIdReceived) {
            connectionID = "<unspecified>";
            if (!"1.0".equals(parser.getAttributeValue("", "version"))) {
                // Notify that a stream has been opened if the
                // server is not XMPP 1.0 compliant otherwise make the
                // notification after TLS has been negotiated or if TLS
                // is not supported
                releaseConnectionIDLock();
            }
        }
    }
}