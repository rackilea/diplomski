@RequestMapping(value="/client/view")
public String viewClientPage(Model m) {

   Client c = new Client( "Jeffrey", "123456" );
   m.addAttribute( "client", c );
   return "[name of a client using view goes here]";

}