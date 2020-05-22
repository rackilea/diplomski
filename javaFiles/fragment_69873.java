@Entity
class Role_UI{

   @ManyToOne
   Role role;
   @ManyToOne
   UIElement element;
   @Enumeration
   Permission property;
}


enum Permission{
   CREATE, EDIT, READ;
}