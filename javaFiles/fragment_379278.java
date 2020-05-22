public enum TaskType {

    CREATE_MATERIAL{
        @Override
        public void handleTask(AService service, ScheduledEvent scheduledEvent) {
            service.createMaterial(scheduledEvent);
        }
    };

    public abstract void handleTask(AService service, ScheduledEvent scheduledEvent);
}