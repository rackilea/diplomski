public class DelegatingEntityListener{

    public interface PrePersistSupport{
        void prePersist();
    }

    public interface PostPersistSupport{
        void postPersist();
    }

    public interface PreRemoveSupport{
        void preRemove();
    }

    public interface PostRemoveSupport{
        void postRemove();
    }

    public interface PreUpdateSupport{
        void preUpdate();
    }

    public interface PostUpdateSupport{
        void postUpdate();
    }

    public interface PostLoadSupport{
        void postLoad();
    }

    @PrePersist
    public void prePersist(final Object entity){
        if(entity instanceof PrePersistSupport){
            ((PrePersistSupport) entity).prePersist();
        }
    }

    @PostPersist
    public void postPersist(final Object entity){
        if(entity instanceof PostPersistSupport){
            ((PostPersistSupport) entity).postPersist();
        }
    }

    @PreRemove
    public void preRemove(final Object entity){
        if(entity instanceof PreRemoveSupport){
            ((PreRemoveSupport) entity).preRemove();
        }
    }

    @PostRemove
    public void postRemove(final Object entity){
        if(entity instanceof PostRemoveSupport){
            ((PostRemoveSupport) entity).postRemove();
        }
    }

    @PreUpdate
    public void preUpdate(final Object entity){
        if(entity instanceof PreUpdateSupport){
            ((PreUpdateSupport) entity).preUpdate();
        }
    }

    @PostUpdate
    public void postUpdate(final Object entity){
        if(entity instanceof PostUpdateSupport){
            ((PostUpdateSupport) entity).postUpdate();
        }
    }

    @PostLoad
    public void postLoad(final Object entity){
        if(entity instanceof PostLoadSupport){
            ((PostLoadSupport) entity).postLoad();
        }
    }

}