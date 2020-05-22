public final class BlueModule extends PrivateModule {
  bind(ExecutorService.class).toInstance(Executors.newCachedThreadPool());
  bind(BlueService.class).to(BlueServiceImpl.class);

  expose(ExecutorService.class);
  expose(BlueService.class);
}

public final class RedModule extends PrivateModule {
  bind(ExecutorService.class).toInstance(Executors.newCachedThreadPool());
  bind(RedService.class).to(RedServiceImpl.class);

  expose(ExecutorService.class);
  expose(RedService.class);
}