final Iterator<JLabel> labelIter = labels.iterator();
while(labelIter.hasNext()) {
    final JLabel label = labelIter.next();
    //do stuff with label
    labelIter.remove();
}