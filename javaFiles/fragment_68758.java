@Entity
public class Persona {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;


@Entity
public class Titular implements Afiliado {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @JoinColumn(nullable = false)
   @ManyToOne(optional = false)
   private Persona persona;

@Entity
public class Familiar implements Afiliado {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   @JoinColumn(nullable = false)
   @ManyToOne(optional = false)
   private Persona persona;
   @ManyToOne
   private Titular titular;

public interface Afiliado {
   public String getNumero();
   //trick but necessary
   public Persona getPersona();

   //another default Java 8 implementations..
}