@Transactional
@RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String saveOrder(@ModelAttribute("user") User user, BindingResult result, @RequestParam String action){
    emailDAO.create(user.getEmail()); // Inserting Email as New Record
    userDAO.create(user);
    return "index";
...
}