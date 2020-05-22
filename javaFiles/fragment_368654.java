ScheduledExecutorService scheduledExecutorService = 
    mock(ScheduledExecutorService.class);

ScheduledFuture<?> future = 
    thenReturnMockFuture(
        when(scheduledExecutorService.schedule(...)));