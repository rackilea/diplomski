protected interface Templates extends SafeHtmlTemplates {
    @SafeHtmlTemplates.Template("<button type=\"button\" value=\"{0}\" tabindex=\"-1\">{1}</button>")
    SafeHtml button(String value, String label);
}
private static Templates templates = GWT.create(Templates.class);
public void render() {
    SafeHtml rendered = templates.button("myValue", "myLabel");
    // ... then inject HTML in some HTMLPanel
}