@Component
public class ParentJpaCallbacksListener {
    @Autoware ChildRepository childRepository;

    @PreRemove
    // or @PostRemove
    void preRemove(Parent parent) {
        // your cascade deletion logic 
        // for example use childRepository to delete some children
    }

}