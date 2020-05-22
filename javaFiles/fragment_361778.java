public class ProjectExplorerPart {

  protected TreeViewer viewer;

  @PostConstruct
  public void createComposite(Composite parent, IEclipseContext context) {
    //...

    OpenProjectItemHandler handler
        = ContextInjectionFactory.make(OpenProjectItemHandler.class, context);

    viewer.addDoubleClickListener(handler);

    //...
  }
}