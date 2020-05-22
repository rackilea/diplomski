import lombok.Data;

@Data public class Cart {
  private int id;
  private DateTime created;
  private int items;
  private int status;
}