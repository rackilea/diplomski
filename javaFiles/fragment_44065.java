mainTabs.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    switch (mainTabs.getSelectedIndex()) {
                    case 0:
                    case 1:
                    case 2: // stats tab
                        GuiWorker gw = new GuiWorker(editor,st);
                        gw.execute();
                        gw.setVisible(true);
                        break;
                    default:
                        break;
                    }
                }
            });