@PostMapping("/login")
public ModelAndView loginUser(@RequestParam ("userId") String userID, @ModelAttribute ("user") User user, RedirectAttributes attr){
  ...
  attr.addFlashAttribute("user",user);
  attr.addFlashAttribute("userId", userID);
  return modelAndView;