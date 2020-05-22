Map<Integer, Panel> panelMap = ...
for(int i = 1; i < 10; i++) {
    Panel panel = new Panel();
    panelMap.put(i, panel); 
}

panelMap.get(1).addLabel(labelForPanel1); (for all labels)