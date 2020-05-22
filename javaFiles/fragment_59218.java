@Retention(RUNTIME)
@NormalScope(passivating = true)
@DynamicScope({
    @Scope(scope = ThreadScoped.class),
    @Scope(scope = ConversationScoped.class, ifExpression = "#{not javax.enterprise.context.conversation.transient}"),
    @Scope(scope = ViewScoped.class, ifExpression = "#{not facesContext.viewRoot.transient}"),
    @Scope(scope = RequestScoped.class)
})
public @interface UnitOfWorkScoped {}