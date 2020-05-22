final JScrollPane p = new JScrollPane();
    p.setViewportView(table);
    p.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){ 
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            // here the control if vertical scroll bar has reached the maximum value
            if(!e.getValueIsAdjusting()){
                JScrollBar source = (JScrollBar) e.getAdjustable();
                int extent = source.getModel().getExtent();
                int maximum = source.getModel().getMaximum();
                if(e.getValue() + extent == maximum){
                    retrieveData();
                }
            }

        }
    });