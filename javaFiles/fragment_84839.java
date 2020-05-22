JTextArea ta = new JTextArea(String.valueOf(value));
        ta.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                panel.setSize(panel.getPreferredSize());
            }

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentMoved(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
        });

        panel.add(ta);