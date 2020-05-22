editor.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    try {
                        String rowcode = e.getDescription();
                int row = Integer.parseInt(rowcode.replace("#row",""));
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }

        });