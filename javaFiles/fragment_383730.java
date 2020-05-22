public SOAPService getService(String name) throws AxisFault
    {
        try {
            return config.getService(new QName(null, name));
        } catch (ConfigurationException e) {
            try {
                return config.getServiceByNamespaceURI(name);
            } catch (ConfigurationException e1) {
                throw new AxisFault(e);
            }
        }
    }