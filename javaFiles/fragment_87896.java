public void injectJarIntoJar(final String processIdOfTargetJar,
        final String pathToAgentJar, final String[] argumentsToPass) {
    try {
        final VirtualMachine vm = VirtualMachine.attach(processIdOfTargetJar);
        vm.loadAgent(pathToAgentJar, argumentsToPass.toString());
        vm.detach();
    } catch (AttachNotSupportedException | AgentLoadException
            | AgentInitializationException | IOException e) {
        System.err.println("Unable to inject jar into target jar.");
    }
}