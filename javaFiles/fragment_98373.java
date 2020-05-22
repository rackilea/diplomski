public class Booking {
  private List<Guest> list;

  public Booking(List<Guest> list) {
    this.list = list; // Using of this
  } 

  public List<Guest> getList() {
    return list;
  }
}