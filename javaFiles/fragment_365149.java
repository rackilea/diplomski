@RequestMapping(value="/my_children", method = RequestMethod.GET)
public void viewMyChild(ModelMap modelMap) {
    ChildNameAccess childNameDAO = new ChildNameAccess();
    try{
        List<Child> children = childNameDAO.getChildDataByMotherId("M-1");

        modelMap.addAttribute("children ",children);
    }

    catch(SQLException e) {
        e.printStackTrace();
    }
}