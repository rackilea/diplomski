RunJobFlowRequest runJobFlowRequest = new RunJobFlowRequest("Main", jobFlowInstancesConfig)
            .withName("SDK_filtering" + System.currentTimeMillis())
            .withAmiVersion("3.7.0")
            .withVisibleToAllUsers(true)
            .withServiceRole("EMR_DefaultRole")
            .withJobFlowRole("EMR_EC2_DefaultRole")
            .withBootstrapActions(
                    new BootstrapActionConfig("Install Hue",
                            new ScriptBootstrapActionConfig("s3://us-west-1.elasticmapreduce/libs/hue/install-hue", null)))
            .withSteps(
                    newEnableDebugStep(),
                    newInstallHiveStep(),
                    newInstallPig(),
                    newRunHueStep()
            );