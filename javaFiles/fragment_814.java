private void XMPPConnectionListener() {
    XMPPConnection.addConnectionCreationListener(new ConnectionCreationListener() {

        @Override
        public void connectionCreated(XMPPConnection connection) {
            GlobalVar.XMPPConn = connection;
            ChatHelper.idleMessageListener(StartActivity.this);

        }
    });

}