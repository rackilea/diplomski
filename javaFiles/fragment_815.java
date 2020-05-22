public static void idleMessageListener(final Activity activity) {
    PacketListener myListener = new PacketListener() {
        public void processPacket(final Packet packet) {
            final Integer userID = Integer.parseInt(returnIDFromPacket(packet.getFrom()));
            final String body = returnBodyFromPacket(packet.toString());
            if (!GlobalVar.currentOpponent.equals(userID) && !body.isEmpty()) {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        QBUsers.getUser(userID, new QBEntityCallbackImpl<QBUser>() {
                            @Override
                            public void onSuccess(final QBUser user, Bundle args) {
                                sendNotification(activity, user, body);
                            }

                            @Override
                            public void onError(List<String> errors) {
                                Log.d(TAG, errors.toString());
                            }
                        });
                    }
                });

            }
        }
    };
    PacketFilter filter = new MessageTypeFilter(Message.Type.chat);

    if (GlobalVar.XMPPConn != null) {
        GlobalVar.XMPPConn.addPacketListener(myListener, filter);
    }
}