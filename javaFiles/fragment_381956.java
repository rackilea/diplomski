for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    for (InetAddress address : Collections.list(ni.getInetAddresses())) {
                        if (address instanceof Inet4Address) {
                            String ipadr = address.toString().replaceAll("/", "");
                            ipadr = ipadr.replaceAll("127.0.0.1", "");
                            if (!ipadr.equalsIgnoreCase("")) {
                                ipss.add(ipadr);
                            }
                        }
                    }
                }