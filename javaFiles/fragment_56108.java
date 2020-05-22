package com.ntg.crm.internal.entites;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "Mission.findAllMissionsMapping", entities = @EntityResult(entityClass = Mission.class, fields = {
        @FieldResult(name = "name", column = "mname"), @FieldResult(name = "id", column = "mid")
}))
@NamedNativeQuery(name = "Mission.findAllMissions", query = "select m.id as mid,m.name as mname , info.id uid ,info.name uname from Mission m join user_info_missions um on m.id "
        + "= um.missions_id join user_Info info on info.id = um.user_id where info.name =:userName", resultSetMapping = "Mission.findAllMissionsMapping")

@Entity
public class Mission {

    public Mission() {

    }

    public Mission(BigInteger id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Mission(BigInteger id, String name, List<User> users) {
        super();
        this.id = id;
        this.name = name;
        this.users = users;
    }

    @Id
    BigInteger id;
    String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_info_missions", joinColumns = @JoinColumn(name = "missions_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> users;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}