JEditorPane ep = new JEditorPane("text/html", "Some HTML code will go here. You can have &lt;a href=\"do1\">links&lt;/a> in it. Or other &lt;a href=\"do2\">links&lt;/a>.");
ep.addHyperlinkListener(new HyperlinkListener() {
         public void hyperlinkUpdate(HyperlinkEvent arg0) {
            String data = arg0.getDescription();
            if(data.equals("do1")) {
                //do something here
            }
            if(data.equals("do2")) {
                //do something else here
            }
        }
    });