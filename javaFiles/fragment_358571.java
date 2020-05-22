public class ToggleVisibilityLink extends AjaxFallbackLink<Boolean>
{
  static {
    Application.get().getSharedResources().add("ToggleVisibilityLinkCollapse",
                                               new MyPackageResource(ToggleVisibilityLink.class, "collapse.png"));
    Application.get().getSharedResources().add("ToggleVisibilityLinkExpand",
                                               new MyPackageResource(ToggleVisibilityLink.class, "expand.png"));
  }

  public ToggleVisibilityLink(final String id, final IModel<Boolean> model)
  {
    super(id, model);

    setOutputMarkupId(true);
    setEscapeModelStrings(false);

    setBody(new BodyModel(model));
  }

  @Override
  public void onClick(final AjaxRequestTarget target)
  {
    setModelObject(!getModelObject());
    if (target != null)
    {
      target.add(this);
      send(this.getParent(), Broadcast.EXACT, target);
    }
  }

  private static final class BodyModel extends AbstractReadOnlyModel<String>
  {
    private final IModel<Boolean> model;

    private BodyModel(final IModel<Boolean> model)
    {
      this.model = model;
    }

    @Override
    public String getObject()
    {
      return this.model.getObject() ?
              "<img src=\""
            + RequestCycle.get().urlFor(new SharedResourceReference("ToggleVisibilityLinkExpand"), null)
            + "\" class=\"collapseExpandImage expand\">"
              :
              "<img src=\""
            + RequestCycle.get().urlFor(new SharedResourceReference("ToggleVisibilityLinkCollapse"), null)
            + "\" class=\"collapseExpandImage collapse\">";
    }
  }
}