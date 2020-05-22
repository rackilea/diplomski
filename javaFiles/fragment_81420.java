@UiField
MyMenuBar myMenuBar;

....

menuItem.setScheduledCommand(new ScheduledCommand() {
            @Override
            public void execute() {
                if (!wasHoveredWhenClosed) {
                    window.init();
                    window.addCloseHandler(new CloseHandler<PopupPanel>() {
                        @Override
                        public void onClose(final CloseEvent<PopupPanel> event) {
                            wasHoveredWhenClosed = myMenuBar.getSelectedItem() != menuItem;
                        }
                    });
                    window.show();
                } else {
                    wasHoveredWhenClosed = false;
                }
            }
        });