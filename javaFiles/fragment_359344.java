public Chapter copy(){
    Chapter copy = new Chapter();
    copy.setTitle(this.title);
    copy.setLink(this.link);
    copy.setDescription(this.description);
    copy.setDate(this.date);
    return copy;
}