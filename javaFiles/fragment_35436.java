// Get the SecurityContext hold by the main thread
 final SecurityContext securityContext = SecurityContextHolder.getContext();

 final ScheduledFuture<NodeRef> scheduledFuture = nodeCreationExecutor.schedule(new Callable<NodeRef>() {

  @Override
   public NodeRef call() throws Exception {

    // Inject the securityContext 
    SecurityContextHolder.setContext(securityContext);

    // HERE I MAKE THE EFFECTIVE NODE CREATION
    NodeRef noderef = createNodeRef(filename, type, parentNode, label, kinematic);

    // Cleaning...the thread may be recycled
    SecurityContextHolder.setContext(null);

    return noderef;

 }
}, MAX_NODE_CREATION_DELAY_IN_SECONDS, SECONDS);