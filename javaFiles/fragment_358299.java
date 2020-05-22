package test;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.velocity.tools.ConversionUtils;
import org.apache.velocity.tools.generic.ResourceTool;

public class UTF8ResourceTool extends ResourceTool {

    /**
     * Retrieves the {@link ResourceBundle} for the specified baseName and
     * locale, if such exists, using UTF-8 encoding. If the baseName or locale is null or if the
     * locale argument cannot be converted to a {@link Locale}, then this will
     * return null.
     */
    protected ResourceBundle getBundle(String baseName, Object loc) {
        Locale locale = (loc == null) ? getLocale() : toLocale(loc);
        if (baseName == null || locale == null) {
            return null;
        }
        return ResourceBundle.getBundle(baseName, locale, new UTF8Control());
    }

    /* Copied here from parent class because it's private there */
    private Locale toLocale(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Locale) {
            return (Locale) obj;
        }
        String s = String.valueOf(obj);
        return ConversionUtils.toLocale(s);
    }

}