if (callEv instanceof TermConnActiveEv) {
    CiscoCall thisCall = (CiscoCall) callEv.getCall();
    TerminalConnection tc = thisCall.getConferenceController();
    Connection[] connections = thisCall.getConnections();

    TerminalConnection[] tcs = connections[0].getTerminalConnections();
    if (tcs.length > 0 && tc == null) {
        tc = tcs[0];
    }

    if (tc == null) {
        System.out.println("Conference controller is null.");
    } else {
        try {
            Call call = provider.createCall();
            call.connect(thisAddress.getTerminals()[0], thisAddress, superVisorAddress);
            thisCall.conference(call);
        } catch (Exception ex) {
            System.out.println("Exception " + ex);
            ex.printStackTrace();
        }
    }
}