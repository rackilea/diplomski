public void sendIdle() {
        if(comm_ip != null) {
            synchronized(comm_pkt) {
                try {
                    comm_pkt.setData(new byte[]{1, ProtocolWrapper.IDLE});
                    comm_skt.send(comm_pkt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }