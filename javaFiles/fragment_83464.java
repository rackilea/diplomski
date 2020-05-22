@Component(property = {
    ResourceChangeListener.CHANGES + "=ADDED",
    ResourceChangeListener.PATHS + "=glob:/content/*",
})
public class ResourceObserver implements ResourceChangeListener {

  @Override
  public void onChange(@Nonnull List<ResourceChange> changes) {
      //go through the list of changes and do what you need to do.
  }
}