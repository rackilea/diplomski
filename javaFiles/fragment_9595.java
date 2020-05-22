@Controller
class TestController {

   private ArrayList<ClientWithSelection> allClientsWithSelection = new ArrayList<ClientWithSelection>();

   public TestController() {
      /* Dummy data */
      allClientsWithSelection.add(new ClientWithSelection(false, "1", "192.168.0.10", "Client A"));
      allClientsWithSelection.add(new ClientWithSelection(false, "2", "192.168.0.11", "Client B"));
      allClientsWithSelection.add(new ClientWithSelection(false, "3", "192.168.0.12", "Client C"));
      allClientsWithSelection.add(new ClientWithSelection(false, "4", "192.168.0.13", "Client D"));
   }

   @RequestMapping("/")
   String index(Model model) {

      ClientWithSelectionListWrapper wrapper = new ClientWithSelectionListWrapper();
      wrapper.setClientList(allClientsWithSelection);
      model.addAttribute("wrapper", wrapper);

      return "test";
   }

   @RequestMapping(value = "/query/submitQuery", method = RequestMethod.POST)
   public String processQuery(@ModelAttribute ClientWithSelectionListWrapper wrapper, Model model) {

      System.out.println(wrapper.getClientList() != null ? wrapper.getClientList().size() : "null list");
      System.out.println("--");

      model.addAttribute("wrapper", wrapper);

      return "test";
   }
}