package com.example;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.sun.faces.renderkit.html_basic.BodyRenderer;

public class BodyWithIdRenderer extends BodyRenderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        super.encodeBegin(context, component);

        if (component.getId() != null) {
            context.getResponseWriter().writeAttribute("id", component.getClientId(context), "id");
        }
    }

}