@Entity
public class User {

@ManyToMany
@JoinTable(name="USER_FILE_ACCESS"
     joinColumns=@JoinColumn(name="user_id"),
        inverseJoinColumns=@JoinColumn(name="fileHasAccess_ID "))
public Set<FileObject> fileHasAccess;


@Entity
public class FileObject {

@ManyToMany
@JoinTable(name="USER_FILE_ACCESS"
         joinColumns=@JoinColumn(name="fileHasAccess_ID"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    public Set<User> listUserAccessor;