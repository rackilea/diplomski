public abstract class Command {
  public final Object execute(Map<String, Object> args) {
    // do permission checking here or transaction management
    Object retval = doExecute(args);
    // do logging, cleanup, caching, etc here
    return retval;
  }
  // subclasses override this to do the real work
  protected abstract Object doExecute(Map<String, Object> args);
}