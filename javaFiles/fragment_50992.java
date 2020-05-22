scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            repaint();
        }
    });