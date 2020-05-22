public void packetDecompose(DatagramPacket packet) {
            // packet has this structure
            // 1 byte                       user length in bytes
            // ? bytes                      user String
            // 1 byte                       password length in byte
            // ? bytes              password String
            clientAddress = packet.getAddress();
            byte[] userLength = new byte[]{packet.getData()[0]};
            String user = new String(packet.getData(), 1, (int)userLength[0]);
            byte[] passwordLength = new byte[]{packet.getData()[(int)userLength[0]+1]};
            String password = new String(packet.getData(), (int)userLength[0]+2, (int)passwordLength[0]);
            System.out.println("Packet content: \nuser: "+user+"\npassword: "+password);
            boolean exists = userExists(user, password);
            byte[] buf = new byte[128];
            if(exists) {
                    System.out.println("User exists");
                    System.arraycopy( accessGranted.getBytes(), 0, buf, 0, Math.min(
accessGranted.getBytes().length, 128 ) );
                    send(new DatagramPacket(buf, 128, clientAddress, 4445));
            } else {
                    System.out.println("User does not exist");
                    System.arraycopy( accessDenied.getBytes(), 0, buf, 0, Math.min(
accessDenied.getBytes().length, 128 ) );
                    send(new DatagramPacket(buf, 128, clientAddress, 4445));
            }

    }