final JEditorPane pane = new JEditorPane("http://swingx.java.net");
    pane.setEditable(false);
    ToolTipManager.sharedInstance().registerComponent(pane);

    HyperlinkListener l = new HyperlinkListener() {
        @Override
        public void hyperlinkUpdate(HyperlinkEvent e) {
            if (HyperlinkEvent.EventType.ACTIVATED == e.getEventType()) {
                try {
                    pane.setPage(e.getURL());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }

    };
    pane.addHyperlinkListener(l);