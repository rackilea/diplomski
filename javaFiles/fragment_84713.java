public final class HookOnDestroy implements Runnable {
    private final Runnable action;
    private final Runnable hook;
    public HookOnDestroy(Runnable action, Runnable hook) {
          this.hook = hook;
          this.action = action;
    }

    @Override
    public void run() {
       try {
         action.run();
       } finally {
         hook.run();
       }
    }

}