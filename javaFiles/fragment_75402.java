protected void handlePopup(MouseEvent e) {
        final VisualizationViewer<MyNode, MyEdge> vv = (VisualizationViewer<MyNode, MyEdge>)e.getSource();
        Point2D p = e.getPoint();
        GraphElementAccessor<MyNode, MyEdge> pickSupport = vv.getPickSupport();
        if(pickSupport != null) {
            final MyNode v = pickSupport.getVertex(vv.getGraphLayout(), p.getX(), p.getY());

            // if clicked on a vertex -> show info popup
            // else show contexual menu
            if(v != null) {
                JFrame popup = new JFrame("Node: " + v.getId());
                popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ...
            } else{
                JPopupMenu menu = new JPopupMenu();
                JMenuItem exportGraphMenuItem = new JMenuItem("Export graph to vector image...");
                exportGraphMenuItem.addActionListener(new ExportActionListener((WritingVisualizationViewer<V, E>) vv));
                menu.add(exportGraphMenuItem);
                menu.show(e.getComponent(), e.getX(), e.getY());
            } 
        }
    }