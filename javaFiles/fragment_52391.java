class MyAttribute {
  final String postName;
  final PictureItem postPicture;
  final Date postDate;
  public MyAttribute(String postName, PictureItem postPicture, Date postDate) {
    this.postName = postName;
    this.postPicture = postPicture;
    this.postDate = postDate;
  }

  public String getPostName() {
    return postName;
  }
  public Date getPostDate() {
    return postDate;
  }
  public PictureItem getPostPicture() {
    return postPicture;
  }
}