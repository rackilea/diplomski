class Book implements Serializable{
  String title;
  String author;
  public Book(String t, String a){
     title = t;
     author = a;
  }
  public String toString(){
     return title + "\t" + author;
  }
}