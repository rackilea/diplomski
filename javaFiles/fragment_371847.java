public class MyController{

      @ModelAttribute("pc")
      public PersonneClass getPersonnelClass(){
        return new PersonneClass();
      }

     @RequestMapping ("/NewMVCCall")
     Public void newMVCPage(@ModelAttribute ("pc") personclass pc, Model model)
     {
        //process pc object
     }
  //other methods

}