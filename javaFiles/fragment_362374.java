package view;

import helper.AppHelper;

import java.util.Locale;

import org.springframework.web.servlet.View;

public class InternalResourceViewResolver extends
        org.springframework.web.servlet.view.InternalResourceViewResolver {

    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        AppHelper.setPage("../" + AppHelper.getModule() + "/" + viewName + ".jsp");
        return super.resolveViewName("layout/" + AppHelper.getLayout(), locale);
    }

}