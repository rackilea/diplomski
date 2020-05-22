public Book getBk() {
    return book;
}
public void setBk(Book bk) {
    this.book = bk;
}
public Node(Book bk) {
    super();
    this.book = bk;
    this.link=null;
    this.root=null;

}