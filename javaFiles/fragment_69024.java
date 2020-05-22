public class TooltipTextCell extends TextCell {
  public interface Template extends SafeHtmlTemplates {
    @Template("<div title=\"{1}\" />{0}</div>")
    SafeHtml label(SafeHtml text, String title);
  }
  private static Template template;

  public TooltipTextCell() {
    super();
    if (template == null) {
      template = GWT.create(Template.class);
    }
  }

  @Override
  public void render(Context context, SafeHtml value, SafeHtmlBuilder sb) {
    if (value != null) {
      sb.append(template.label(value, value.asString()));
    }
  }
}