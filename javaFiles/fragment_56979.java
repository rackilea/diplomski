@Stateless
@LocalBean // <-- no-interface view
class Bean implements IBean {
...
}  

interface IBean {
....
}

@SessionScoped
class Scoped {
   @Inject
   Bean bean; //Should be OK
}