public class SpringDIActor implements IndirectActorProducer {

private static final Logger LOG = LoggerFactory.getLogger(SpringDIActor.class);

private Class<? extends Actor> type;
private Actor actorInstance = null;

public SpringDIActor(Class<? extends Actor> type) {
    this.type = type;
}

public SpringDIActor(Actor actorInstance) {
    this.actorInstance = actorInstance;
}

/**
 * This factory method must produce a fresh actor instance upon each
 * invocation. <b>It is not permitted to return the same instance more than
 * once.</b>
 */
@Override
public Actor produce() {
    Actor newActor = actorInstance;
    actorInstance = null;
    if (newActor == null) {
        try {
            newActor = type.newInstance();
        } catch (InstantiationException e) {
            LOG.error("Unable to create actor of type:{}", type, e);
        } catch (IllegalAccessException e) {
            LOG.error("Unable to create actor of type:{}", type, e);
        }
    }
    ApplicationContextProvider.getApplicationContext().getAutowireCapableBeanFactory().autowireBean(newActor);
    return newActor;
}

/**
 * This method is used by [[Props]] to determine the type of actor which will
 * be created. This means that an instance of this `IndirectActorProducer`
 * will be created in order to call this method during any call to
 * [[Props#actorClass]]; it should be noted that such calls may
 * performed during actor set-up before the actual actor’s instantiation, and
 * that the instance created for calling `actorClass` is not necessarily reused
 * later to produce the actor.
 */
@Override
public Class<? extends Actor> actorClass() {
    return type;
}}