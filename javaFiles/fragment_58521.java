@Entity
public class Car extends Model{

//other fields

@ManyToMany
public List<User> users=new ArrayList<User>();

}

@Entity
public class User extends Model{

 //other fields    

@ManyToMany
public List<Car> users=new ArrayList<Car>();

}