//Create a view that inherites from InlineView and behave the way you want.
    //In your case, it should react to getAttributes().getAttribute(CSS.Attribute.DISPLAY);
    private class HideableView extends InlineView {
        public HideableView(Element elem) { super(elem); }
        //Implement your expected behaviour here
        @Override
        public void paint(Graphics g, Shape a){}
    }


    //Create a View Factory that will replace InlineViews by your custom View
    public static class HTMLBetterFactory extends HTMLEditorKit.HTMLFactory {
        @Override
        public View create(Element elem) {
            AttributeSet attrs = elem.getAttributes();
            Object elementName = attrs.getAttribute(AbstractDocument.ElementNameAttribute);
            Object o = (elementName != null) ? null : attrs.getAttribute(StyleConstants.NameAttribute);
            if (o == HTML.Tag.CONTENT) {
                if(attrs.getAttribute(CSS.Attribute.DISPLAY).toString().equals("none"))
                      return new HideableView(elem);
            }
            return super.create(elem);
        }
    }


//Create an HTMLEditorKit that will use your custom Factory
public class HTMLBetterEditorKit extends HTMLEditorKit {

    private final HTMLEditorKit.HTMLFactory factory = new HTMLBetterFactory();
        @Override
        public ViewFactory getViewFactory() {
            return factory;
        }
    }
}

//Import your HTMLEditorKit into your JTextPane
HTMLBetterEditorKit editorKit = new HTMLBetterEditorKit();
myJTextPane.setEditorKit(editorKit);