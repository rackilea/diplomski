package db;
public class Book{
  private String id;
  private String name;
  private String author;
  private String publisher;
  private String price;

  public String getId(){
    return this.id;
  }
  public void setId(String id){
    this.id = id;
  }

  public String getName(){
    return this.name;
  }
  public void setName(String name){
    this.name = name;
  }

  public String getAuthor(){
    return this.author;
  }
  public void setAuthor(String author){
    this.author = author;
  }

  public String getPublisher(){
    return this.publisher;
  }
  public void setPublisher(String publisher){
    this.publisher = publisher;
  }

  public String getPrice(){
    return this.price;
  }
  public void setPrice(String price){
    this.price = price;
  }

  @Override
  public int hashCode(){
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj)
      return true;
    if(obj == null)
      return false;
    if(getClass() != obj.getClass())
      return false;
    Book other = (Book) obj;
    if(this.id == null){
      if(other.id != null)
        return false;
    }else if(!this.id.equals(other.id))
      return false;
    return true;
  }

  public void setValue(String columnName, String colData){
    if(columnName.contentEquals("BookName")){
      setName(colData);
    }else if(columnName.contentEquals("Author")){
      setAuthor(colData);
    }else if(columnName.contentEquals("Publisher")){
      setPublisher(colData);
    }else if(columnName.contentEquals("Price")){
      setPrice(colData);
    }else{
      //BookId
      setId(colData);
    }
  }

  public String getValue(String columnName){
    String value = "";
    if(columnName.contentEquals("BookName")){
      value = getName();
    }else if(columnName.contentEquals("Author")){
      value = getAuthor();
    }else if(columnName.contentEquals("Publisher")){
      value = getPublisher();
    }else if(columnName.contentEquals("Price")){
      value = getPrice();
    }else{
      //BookId
      value = getId();
    }
    return value;
  }
}