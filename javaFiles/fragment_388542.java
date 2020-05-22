@PostMapping("/register")
public String register(@ModelAttribute("user") UserForm userForm, BindingResult bindingResult) {
    if (!bindingResult.hasErrors()) {
      User user = new User();
      user.setName(userForm.getUsername());
      user.setPassword(encrypt(userForm.getPassword());
      user.setAvataor(createFile(userForm.getAvatar());
      userService.register(user);
      return "success";
    } else {
      return "register";
    }
}