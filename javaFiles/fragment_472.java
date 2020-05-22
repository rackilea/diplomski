public interface SpecialDboMultiselectorService extends MultiselectorService {


  }

  @Stateless
  public class SpecialDboMultiselectorServiceImpl extends MultiselectorServiceImpl<SpecialDbo> implements SpecialDboMultiselectorService
  {

        public SpecialDboMultiselectorServiceImpl() {
             super(SpecialDbo.class);
        }
  }


  public class MultiselectorServiceImpl<T extends Dbo> implements MultiselectorService {

     @Inject  
     private EntityManager em;

     private Class<? extends Dbo> clazz;

     private List<T> itemList;

     public MultiselectorService(Class<? extends Dbo> clazz) {
         this.clazz = clazz
     }

     @PostConstruct
     public void init() {
        itemList = em.createQuery("some Sql String", clazz);
     }
  }