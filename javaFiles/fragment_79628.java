public JdbcContactDao dao;

@Resource(name="dao")
public void setDao(JdbcContactDao dao){
    this.dao = dao;
}


@RequestMapping(value="/contact/list2",method = RequestMethod.GET)
public String getAll(ModelMap model) {

    List<Contact> contacts = dao.findAll();

    // Attach persons to the Model
    model.addAttribute("contacts", contacts);


    return "contact.list";

}