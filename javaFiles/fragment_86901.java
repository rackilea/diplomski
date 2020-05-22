tbFile = new JToolBar();
    final HierarchyListener hierarchyListener = new HierarchyListener() {

        @Override
        public void hierarchyChanged(HierarchyEvent e) {

            if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) == 0) return;
            JToolBar bar = (JToolBar) e.getComponent();
            if (!((BasicToolBarUI) bar.getUI()).isFloating()) return;

            Window topLevel = SwingUtilities.windowForComponent(bar);
            if(topLevel == null) return;

            topLevel.dispose();
            ((JDialog) topLevel).setUndecorated(true);
            topLevel.setVisible(true);

        }
    };
    tbFile.addHierarchyListener(hierarchyListener);