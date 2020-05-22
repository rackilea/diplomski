@Stateless
class Bean {
...
}  

@SessionScoped
class Scoped {
   @Inject
   Bean bean; //OK
}