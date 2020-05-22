@Repository( "categoryDao" )
public class SomeDaoImpl implements SomeDao {

   private SessionFactory sessionFactory;

   @Autowired
   public SomeDaoImpl(SessionFactory sessionFactory) {
     this.sessionFactory = sessionFactory;
   }
   ...
}