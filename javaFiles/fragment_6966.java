package org.pscode.ui.applet.appleteer;

import java.awt.Component;
import java.awt.Dimension;

// placeholder component
import javax.swing.JButton;

import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.View;
import javax.swing.text.ComponentView;
import javax.swing.text.PlainView;
import javax.swing.text.ViewFactory;
import javax.swing.text.Element;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;

import org.pscode.ui.applet.appleteer.AppletElement;
import org.pscode.ui.applet.appleteer.AppletLoaderContainer;

import java.util.HashMap;
import java.util.Enumeration;

import java.net.URL;

import java.util.logging.*;

/** The AppletEditorKit extends HTMLEditorKit to support the applet element. */
public class AppletEditorKit extends HTMLEditorKit {

    URL documentBase;

    PseudoBrowser browser;

    static int appletCount;
    static boolean hasNamedApplet;


    public AppletEditorKit(URL documentBase, PseudoBrowser browser) {
        this.documentBase = documentBase;
        this.browser = browser;
        appletCount = 0;
        hasNamedApplet = false;
    }

    public ViewFactory getViewFactory() {
        return new AppletHTMLFactory(documentBase, browser);
    }

    public static class AppletHTMLFactory extends HTMLFactory implements ViewFactory {

        URL documentBase;
        PseudoBrowser browser;

        AppletHTMLFactory(URL documentBase, PseudoBrowser browser) {
            this.documentBase = documentBase;
            this.browser = browser;
        }

        public View create(Element element) {
            AttributeSet set = element.getAttributes();
            Object o =
                element.getAttributes().getAttribute(StyleConstants.NameAttribute);
            if (o instanceof HTML.Tag) {

                HTML.Tag kind = (HTML.Tag) o;

                Logger.getLogger("Appleteer").log(
                    Level.FINEST, "AEK.c  HTML.Tag: " + kind);

                if (kind == HTML.Tag.APPLET ) {


                    if(!contains(element.getAttributes().getAttributeNames(),"endtag")) {
                        View view;
                        try {
                            AppletElement ae = new AppletElement(
                                element,
                                browser,
                                "applet" + appletCount++);
                            view = new AppletView(ae);
                            if ( ae.getName()!=null ) {
                                hasNamedApplet = true;
                            }
                        } catch(Exception e) {
                            return new PlainView(element);
                        }

                        return view;
                    } else {
                        return new PlainView(element);
                        //return null;
                    }
                } else if (kind == HTML.Tag.PARAM) {
                    Logger.getLogger("Appleteer").log(
                        Level.FINEST, "HTML Param: " + kind);
                }
            }
            return super.create( element );
        }
    }

    public static boolean contains(Enumeration en, String name) {
        while( en.hasMoreElements() ) {
            Object o = en.nextElement();
            if (o instanceof HTML.Attribute) {
                Logger.getLogger("Appleteer").log(
                    Level.FINEST, "HTML.Attribute: " + 0);
                if (o.toString().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}