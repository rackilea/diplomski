@Entity
@Table(name = "my_table")
public class Myclass{    

  @Convert(converter=BoolToString.class)
  private Boolean flagged;    
  ...