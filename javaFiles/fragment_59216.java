@Retention(RUNTIME)
@NormalScope(passivating = true) // must be true if any of the delegate context is passivation-capable
@DynamicScope(value = {ThreadScoped.class, ConversationScoped.class, ViewScoped.class, RequestScoped.class}, activation = UnitOfWorkActivation.class)
public @interface UnitOfWorkScoped {

    class UnitOfWorkActivation implements DynamicContextActivation {

        public boolean isActive(Context context) {
            if (context.getScope().equals(ConversationScoped.class)) {
                // I only want long-running conversations here because in JSF there
                // is always a transient conversation per request and it could take
                // precedence over all other scopes that come after it
                return !CDI.current().select(Conversation.class).get().isTransient();
            }
            if (context.getScope().equals(ViewScoped.class)) {
                // Storing things in view scope when the view is transient gives warnings
                return !FacesContext.getCurrentInstance().getViewRoot().isTransient();
            }
            return true;
        }
    }
}