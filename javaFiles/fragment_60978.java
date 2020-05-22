shell.addListener(SWT.Resize, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                if (shell.getFullScreen()) {
                    Rectangle r = getMonitorSize(shell);
                    shell.setSize(r.width, r.height);
                    shell.redraw();
                } else {
                    shell.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
                    shell.redraw();
                }
            }
        });