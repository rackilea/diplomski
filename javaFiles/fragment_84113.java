public void markSectionOne() {
    //supposing the data in markSectionOne is filled...
    this.markingFacade.create(markSectionOne);
    this.setMessage("Mark Saved");
    //after saving...
    markSectionOne = new Marking();
}