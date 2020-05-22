scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent t) {
            if (t.getCode().equals(KeyCode.TAB) && t.isControlDown()) {
                int size = tabPane.getTabs().size();

                if (size > 0) {
                    SkinBase skin = (SkinBase) tabPane.getSkin();
                    TabPaneBehavior tabPaneBehavior = (TabPaneBehavior) skin.getBehavior();

                    int selectedIndex = tabPane.getSelectionModel().getSelectedIndex();

                    if (!t.isShiftDown()) {
                        if (selectedIndex < size -1) {
                            tabPaneBehavior.selectNextTab();
                        } else {
                            tabPaneBehavior.selectTab(tabPane.getTabs().get(0));
                        }
                    } else {
                        if (selectedIndex > 0) {
                            tabPaneBehavior.selectPreviousTab();
                        } else {
                            tabPaneBehavior.selectTab(tabPane.getTabs().get(size - 1));
                        }
                    }

                    t.consume();
                }

            }
        }
    });