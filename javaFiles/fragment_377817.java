@RequestMapping(value = "/uc")
public String userContracts(@RequestParam("nr") String nr, Model model)
{
  List<Contract> ContractList = new ArrayList<Contract>();

  ContractList = cl.getContractsOfUser(nr);
  model.addAttribute("ContractList", ContractList);
    System.out.println("In uc");
    return "UserContracts";
}