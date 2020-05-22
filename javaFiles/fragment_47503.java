public void execute() throws MojoExecutionException, MojoFailureException {
    //insert at start of method to resolve transformationSets fronm descriptors
    if (descriptors != null && descriptors.length > 0) {
        transformationSets = readDescriptors(descriptors);
    }

    ...