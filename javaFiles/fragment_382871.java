public static void _option(Map<?, ?> args, Closure body, PrintWriter out, ExecutableTemplate template, int fromLine) {
    Object value = args.get("arg");
    Object selectedValue = TagContext.parent("select").data.get("selected");
    boolean selected = selectedValue != null && value != null && selectedValue.equals(value);
    out.print("<option value=\"" + (value == null ? "" : value) + "\" " + (selected ? "selected=\"selected\"" : "") + "" + serialize(args, "selected", "value") + ">");
    out.println(JavaExtensions.toString(body));
    out.print("</option>");
}