public static void main(String[] args) throws IOException {
    Handlebars handlebars = new Handlebars();
    Gson gson = new Gson();

    handlebars.registerHelper("getLink", (Helper<String>) (node, options) -> node != null ? node : "");

    String data = "{'data':{'node':'/bla.html', 'node2':'inside node2'}}";
    // Pay attention to parentheses !!!
    String rawTemplate = "{{#if (getLink data.node)}} <a href=\"{{getLink data.node}}\">Link-Text</a> {{/if}}";

    Type type = new TypeToken<Map<String, Object>>(){}.getType();
    Map<String, Object> map = gson.fromJson(data, type);

    Template template = handlebars.compileInline(rawTemplate);
    Context context = Context.newBuilder(map).build();

    System.out.println(template.apply(context));
}