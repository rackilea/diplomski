Myendpoint.Builder endpointBuilder = new Myendpoint.Builder(
                AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
                null);
        endpointBuilder =     CloudEndpointUtils.updateBuilder(endpointBuilder).setApplicationName(MainActivity.APPLICATION_NAME);

        endpoint = endpointBuilder.build();

        try {
             result = endpoint.listStuff().execute();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // SynchKey = 0;
            // result = null;
        }

        return result;