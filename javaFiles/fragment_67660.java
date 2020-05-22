ProgressObject redeployProcessObject = null;
      try {
          final DeploymentOptions options = new DeploymentOptions();
          options.setName(applicationName);
          redeployProcessObject = deployManager.deploy(
              targetModuleIDs, warFilePath, null /*no deployment plan*/, options);
      } catch (TargetException e) {
          final String message =
                  String.format("Deployment of application %s on target %s failed: %s",
                          applicationName, allTargets, e.getMessage());
          _log.error(message, e);
      }