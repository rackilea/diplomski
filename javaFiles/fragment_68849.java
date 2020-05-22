TabPanel panel;
        panel.addBeforeSelectionHandler(new BeforeSelectionHandler<Widget>() {

            @Override
            public void onBeforeSelection(BeforeSelectionEvent<Widget> event) {
                //some condition
                event.cancel();
            }
        });