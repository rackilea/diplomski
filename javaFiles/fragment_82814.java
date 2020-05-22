import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class HandlebarsJavaTest {

    public static void main(String[] args) throws Exception {
        System.out.println(
            new Handlebars()
                .registerHelper("getLink", (Helper<JsonObject>) (json, options) -> {
                    try {
                        // logic here
                        return json.get("data").getAsJsonObject().get("node").getAsJsonObject().get("link").getAsString();
                    } catch (NullPointerException npe) {
                        return null;
                    }
                })
                // Pay attention to parentheses !!
                .compileInline("{{#if (getLink this) }} <a href=\"{{getLink this}}\">Link-Text</a> {{/if}}")
                .apply(
                    Context
                        .newBuilder(
                            new Gson()
                                .fromJson(
                                    "{ 'data': { 'node': { 'link': '/bla.html' }, 'node2': 'inside node2' } }",
                                    JsonObject.class
                                )
                        ).build()
                )
        );
    }
}