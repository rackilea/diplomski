public class DynamicContext implements AlterableContext {

    private final BeanManager beanManager;
    private final DynamicContextActivation activation;
    private final Class<? extends Annotation> scope;
    private final Class<? extends Annotation>[] scopes;

    public DynamicContext(BeanManager beanManager, DynamicContextActivation activation, Class<? extends Annotation> scope, Class<? extends Annotation>[] scopes) {
        this.beanManager = beanManager;
        this.activation = activation;
        this.scope = scope;
        this.scopes = scopes;
    }

    public void destroy(Contextual<?> contextual) {
        Context context = getContext();
        if (context instanceof AlterableContext) {
            ((AlterableContext) context).destroy(contextual);
        }
    }

    public <T> T get(Contextual<T> contextual) {
        return getContext().get(contextual);
    }

    public <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext) {
        return getContext().get(contextual, creationalContext);
    }

    // Find the first active context
    private Context getContext() {
        for (Class<? extends Annotation> scope : this.scopes) {
            try {
                Context context = this.beanManager.getContext(scope);
                if (context.isActive() && this.activation.isActive(context)) {
                    return context;
                }
            } catch (ContextNotActiveException exception) {
                continue;
            }
        }
        return null;
    }

    public Class<? extends Annotation> getScope() {
        return this.scope;
    }

    public boolean isActive() {
        return getContext() != null;
    }
}