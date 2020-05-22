@Entity
public class RectangleEntity
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column
   private Integer x;

   @Column
   private Integer y;

   @Column
   @Convert(converter = ColorConverter.class)
   private Color color;

   ...
}