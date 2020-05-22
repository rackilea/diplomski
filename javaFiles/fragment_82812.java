import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Template;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class HandlebarsJavaTest {

    public static void main(String[] args) throws IOException {
        Handlebars handlebars = new Handlebars();
        Gson gson = new Gson();

        handlebars.registerHelper("getLink", (Helper<Map<String, Object>>) (jsonObject, options) -> {
            String link = fetchLink(jsonObject);
            return link != null ? link : "";
        });

        String data = "{'data':{'node':'/bla.html', 'node2':'inside node2'}}";
        // Pay attention to parentheses !!!
        // {{#if (getLink data.node)}} throws ClassCastException, java.lang.String cannot be cast to java.util.Map
        String rawTemplate = "{{#if (getLink data)}} <a href=\"{{getLink data}}\">Link-Text</a> {{/if}}";

        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> map = gson.fromJson(data, type);

        Template template = handlebars.compileInline(rawTemplate);
        Context context = Context.newBuilder(map).build();

        System.out.println(template.apply(context));
    }

    private static String fetchLink(Map<String, Object> map) {
        try {
            return map.get("node").toString();
        } catch (NullPointerException npe) {
            return null;
        }
    }
}