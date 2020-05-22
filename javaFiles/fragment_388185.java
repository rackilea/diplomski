@Entity
@Table (name = "books")
public class Book  {
  ...
  @Column(name = "description", columnDefinition="TEXT") 
  private String description;
  ...
}