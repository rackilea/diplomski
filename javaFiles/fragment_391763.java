public static synchronized EventCoordinator getEventCoordinator() {
    if (coordinator == null) {
         coordinator = new EventCoordinator();
    }
    return coordinator;
}