final JList list = new JList(model) {

        /** 
         * @inherited <p>
         */
        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }


    };
    list.setCellRenderer(new MyCellRenderer());

    ComponentListener l = new ComponentAdapter() {

        @Override
        public void componentResized(ComponentEvent e) {
            // next line possible if list is of type JXList
            // list.invalidateCellSizeCache();
            // for core: force cache invalidation by temporarily setting fixed height
            list.setFixedCellHeight(10);
            list.setFixedCellHeight(-1);
        }

    };

    list.addComponentListener(l);
    add(new JScrollPane(list));