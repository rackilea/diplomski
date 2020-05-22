@Component
public class SpringExtensionImpl implements Extension {

   @Autowired
   private ApplicationContext applicationContext;

   public Props props(String actorBeanName, Object... args) {
       return (args != null && args.length > 0) ?
            Props.create(SpringActorProducer.class,
                    applicationContext,
                    actorBeanName, args) :
            Props.create(SpringActorProducer.class,
                    applicationContext,
                    actorBeanName);
    }
}

public class SpringActorProducer implements IndirectActorProducer {

    private final ApplicationContext applicationContext;
    private final String actorBeanName;
    private final Object[] args;

    public SpringActorProducer(ApplicationContext applicationContext, String actorBeanName) {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
        this.args = null;
    }

    public SpringActorProducer(ApplicationContext applicationContext, String actorBeanName, Object... args) {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
        this.args = args;
    }

    @Override
    public Actor produce() {
        return args == null ? 
              (Actor) applicationContext.getBean(actorBeanName):
              (Actor) applicationContext.getBean(actorBeanName, args);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }

}