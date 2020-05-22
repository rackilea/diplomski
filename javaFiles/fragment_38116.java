ModelControllerClient client = ModelControllerClient.Factory
        .create(new ModelControllerClientConfiguration.Builder().setHostName(HOSTNAME).setPort(9990)
                .setConnectionTimeout(36000).build());

ModelNode operation = new ModelNode();
operation.get("operation").set("whoami");
operation.get("verbose").set("true");

ModelNode result = client.execute(operation);

System.out.println(result.toString());