*{ we tag required for validation }*
public static void save(@Valid User user) {
   checkAuthenticity();
   if(validation.hasErrors()){
     //there are errors, add to flash and redirect to edit page
   } else {
     user.save();
     //redirect
   }
}