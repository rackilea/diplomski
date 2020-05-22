public static IClasspathEntry getJavaClassPath(String version) {
    IExecutionEnvironmentsManager executionEnvironmentsManager = JavaRuntime
            .getExecutionEnvironmentsManager();
    IExecutionEnvironment[] executionEnvironments = executionEnvironmentsManager
            .getExecutionEnvironments();
    for (IExecutionEnvironment iExecutionEnvironment : executionEnvironments) {
        if (version.equals(iExecutionEnvironment.getId())) {
            return JavaCore.newContainerEntry(JavaRuntime
                    .newJREContainerPath(iExecutionEnvironment));
        }
    }

    return null;
}