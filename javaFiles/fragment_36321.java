segmentNodes.add(myTrip.getTripItem(i)); 
Segment segment = new Segment();
segment.setId(count); 
segment.setNodeIds(segmentNodes); 

Log.d(TAG, "in SM segment " + segment.getId() + " nodes: " 
    + segment.getNodeIds().toString());
segmentNodes.clear(); 
count++; 
segments.add(segment);