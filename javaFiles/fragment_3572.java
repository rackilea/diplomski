public class Record{
  String name;
  String region;

  public boolean equals(Object o){
    Record r = (Record)o;
    return name.equals(r.name) && region.equals(r.region);
  }

  public int hashCode(){
    return name.hashCode()+region.hashCode();
  }
}