private double[] getAngles( SequenceAttribute beamSequence ) {

Iterator is = beamSequence.iterator();
while (is.hasNext()) {
    SequenceItem item = (SequenceItem)is.next();
    if (item != null) { 
        AttributeList itemList = item.getAttributeList();
        if (itemList != null) {
            Attribute ctrlPoint = itemList.get( TagFromName.ControlPointSequence );

            // Do the same sifting through this sequence to get your gantry angle
            // and add it to your list of values.
        }
    }
}