for (Iterator<Batch> i = lstString.iterator(); i.hasNext(); ) {
    Batch value=(Batch )i.next();
    if(lstBatCtrl.get(k).getSequence() == iVal) {
        i.remove();
    }
}