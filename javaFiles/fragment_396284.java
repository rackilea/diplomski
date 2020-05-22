package com.example;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import com.sun.faces.renderkit.html_basic.ScriptRenderer;

public class MultiScriptRenderer extends ScriptRenderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        Map<String, Object> attributes = component.getAttributes();
        String name = (String) attributes.get("name");
        if (name.contains("*")) {
            String pattern = name.replace(".", "\\.").replace("*", ".*");
            String library = (String) attributes.get("library");
            File root = new File(context.getExternalContext().getRealPath("/resources/" + (library != null ? library : "")));
            for (File file : root.listFiles()) {
                if (file.getName().matches(pattern)) {
                    attributes.put("name", file.getName());
                    super.encodeEnd(context, component);
                }
            }
            attributes.put("name", name); // Put original name back. You never know.
        } else {
            super.encodeEnd(context, component);
        }
    }
}