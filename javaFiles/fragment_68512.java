public void setFormListener(Object o) {
    if (o instanceof DailyFormListener) {
        this.formDayListener = (DailyFormListener)o;
    }
    else if (o instanceof GeneFormListener) {
        this.geneFormListener = (GeneFormListener)o;
    }
    else if (o instanceof LabFormListener) {
        this.labFormListener = (LabFormListener)o;;
    }
}