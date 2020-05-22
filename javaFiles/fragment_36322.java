ArrayList<Integer> segCopy = new ArrayList<Integer>();
for(Integer i : segmentNodes){
    segCopy.add(i);
}
segment.setNodeIds(segCopy);
segmentNodes.clear();