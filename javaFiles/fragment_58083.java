@Entity
public class Page{

 @ManyToOne
 private Person creator;
 @OneToMany
 private List<Person> modifiers;
 @ManyToOne
 private Person owner; //which i guess may be the same as owner.

}