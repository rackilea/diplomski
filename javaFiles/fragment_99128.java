Enumeration<NetworkInterface> nis = null;
                try {
                    nis = NetworkInterface.getNetworkInterfaces();
                } catch (SocketException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                NetworkInterface ni;
                while (nis.hasMoreElements()) {
                    ni = nis.nextElement();
                    try {
                        if (!ni.isLoopback() && ni.isUp()) {
                            for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                                //filter for ipv4/ipv6
                                if (ia.getAddress().getAddress().length == 4) {
                                    //4 for ipv4, 16 for ipv6
                                    System.out.println(ia.getAddress());
                                }
                            }
                        }
                    } catch (SocketException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }