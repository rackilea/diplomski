List<Host> aliveHosts = hosts.stream()
                             .parallel()
                             .filter(h -> {
                                            try {
                                              return InetAddress.getByName(h.getIpaddress()).isReachable(TIMEOUT)
                                            } catch(Exception e) {
                                              return false;
                                            }
                                          })
                             .collect(Collectors.toList());