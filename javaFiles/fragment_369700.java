private class FormModel {
    private User user;
    private BookingNumber bookingNumber;

    //Getter Setter ....
}

// show add user form
@RequestMapping(value = "/users/add", method = RequestMethod.GET)
public String showAddUserForm(Model model) {

    logger.debug("showAddUserForm()");
    FormModel formModel = new FormModel ();
    User user = new User();
    Bookingnumber bookingnumber = new Bookingnumber();

    // set default value
    user.setName("setNewUserName");     
    user.setEmail("test123@gmail.com");

    bookingnumber.setBookingnumber("123.456");
    formModel.setUser(user);
    formModel.setBookingNumber(bookingNumber);
    model.addAttribute("formModel", formModel);
    return "users/userform";
}