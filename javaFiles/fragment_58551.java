package com.poc.pages;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

public class IndexPage extends WebPage {
    private String modelValue = "ChangedNormally";
    private boolean focusGained = false;

    public IndexPage() {

        Form form = new Form("form");

        TextField<String> textInput = new TextField<String>("input", new PropertyModel<String>(this, "modelValue"));
        textInput.add(new AjaxEventBehavior( "onfocus" ) {
            @Override
            protected void onEvent(AjaxRequestTarget target) {
                if (!focusGained) {
                    modelValue = "ChangedViaDefaultSetModel";
                    target.add(this.getComponent());
                    focusGained = true;
                    System.out.println( "focus gained " + getComponent().getDefaultModelObject() );
                }
            }
        });
        textInput.add(new AjaxEventBehavior( "onblur" ) {
            @Override
            protected void onEvent(AjaxRequestTarget target) {
                modelValue = "ChangedNormally";
                target.add(this.getComponent());
                focusGained = false;
                System.out.println( "focus lost " + getComponent().getDefaultModelObject() );
            }
        });
        form.add(textInput);
        add(form);
    }
}