public class CustomCell extends TextCell<String> {

  interface Template extends SafeHtmlTemplates {
    @Template("<div style=\"color:{0}\">{1}</div>")
    SafeHtml div(String url, String text);
  }

  private static Template template;

  public CustomCell () {
    if (template == null) {
      template = GWT.create(Template.class);
    }
  }

  @Override
  public void render(Context context, String value, SafeHtmlBuilder sb) {
    String color = "red";
    if (value != null) {
      // The template will sanitize the URI.
      sb.append(template.div(color, value));
    }
  }
}


public class CustomColumn<T> extends TextColumn<T> {

  public CustomColumn() {
    super(new CustomCell());
  }
}