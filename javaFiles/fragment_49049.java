DoThingInALoop mockLoop = Mockito.mock(DoThingInALoop.class);
    Executor mockExecutor = Mockito.mock(Executor.class);
    Boss boss = new Boss(mockExecutor, mockLoop);

    boss.start();

    // No NPE aynymore
    verify(mockExecutor).execute(mockLoop);