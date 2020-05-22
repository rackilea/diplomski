private void doPortForwarding() {

        PortMapping[] desiredMapping = new PortMapping[2];
         desiredMapping[0] = new PortMapping(8123, InetAddress.getLocalHost().getHostAddress(),
                PortMapping.Protocol.TCP, " TCP POT Forwarding");

         desiredMapping[1] = new PortMapping(8123, InetAddress.getLocalHost().getHostAddress(),
                    PortMapping.Protocol.UDP, " UDP POT Forwarding");


         UpnpService upnpService = new UpnpServiceImpl();
         RegistryListener registryListener = new PortMappingListener(desiredMapping);
         upnpService.getRegistry().addListener(registryListener);

        upnpService.getControlPoint().search();

    }