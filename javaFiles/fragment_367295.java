public void UDPListen() {
        while(true) {
            synchronized(stop) {
                if(stop)
                    break;
            }

            byte[] recieve_data = new byte[64];
            DatagramPacket rpkt = new DatagramPacket(recieve_data, recieve_data.length);
            try {
                datagram_server_socket.receive(rpkt);
                int port = 0;
                byte[] rdata = rpkt.getData();
                port += rdata[0]<<24;
                port += rdata[1]<<16;
                port += rdata[2]<<8;
                port += (0XFF)&rdata[3];
                byte[] tid = new byte[rdata.length];
                for(int i = 4; i < rdata.length && rdata[i] > 0; i++)
                {
                    tid[i-4] = rdata[i];
                }
                String thread_id = new String(tid).trim();
                for(int i = 0; i < threads.size(); i++) {
                    ClientThread t = threads.get(i);
                    if(t.getThreadId().compareTo(thread_id) == 0)
                    {
                        t.setCommSocket(rpkt, port, datagram_server_socket);
                    } else {
                        System.err.println("THREAD ID " + thread_id + " COULD NOT BE FOUND");
                    }
                }
            } catch (IOException e) {
                if(!(e instanceof SocketException) && !(e instanceof SocketTimeoutException))
                    log.warning("Error while listening for an UDP Packet.");
            } finally {
                for(int i = 0; i < threads.size(); i++) {
                    ClientThread t = threads.get(i);
                    t.sendKeepAlive();
                }
            }
        }
    }