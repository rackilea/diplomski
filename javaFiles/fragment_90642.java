String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
    int p = nameOfRunningVM.indexOf('@');
    String pid = nameOfRunningVM.substring(0, p);

    try {
        String agentJarPath = null;
        final String classPath = System.getProperty("java.class.path", ".");
        final String[] classPathElements = classPath.split(System.getProperty("path.separator"));
        List<String> retval = new ArrayList<String>();
        for(final String element : classPathElements){
            if(element.contains("<agent-jar-file-name>")){
                agentJarPath = element;
                break;
            }
        }            

        VirtualMachine vm = VirtualMachine.attach(pid);
        vm.loadAgent(agentJarPath, "");   
        vm.detach();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }