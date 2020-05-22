import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<UGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<UGroup> groups) {
        this.groups = groups;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private Set<UGroup> groups=new HashSet<UGroup>();

    public User() {
    }

    public void addGroup(UGroup uGroup) {
        this.groups.add(uGroup);
        uGroup.users.add(this);
    }

    public void removeGroup(UGroup uGroup) {
        this.groups.remove(uGroup);
        uGroup.users.remove(this);
    }
}

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "UGroup")
@Table(name = "groups")
public class UGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_GROUP_MAP" ,joinColumns = @JoinColumn(name="GROUP_ID",referencedColumnName = "ID")
            ,inverseJoinColumns = @JoinColumn(name="USER_ID",referencedColumnName = "ID"))
    @LazyCollection(value = LazyCollectionOption.FALSE)
    public Set<User> users=new HashSet<>();

    public UGroup() {
    }

    public void addUser(User user) {
        this.users.add(user);
        user.addGroup(this);
    }

    public void removeUser(User user) {
        this.users.remove(user);
        user.removeGroup(this);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}