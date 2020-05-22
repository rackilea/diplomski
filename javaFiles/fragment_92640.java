@RequestMapping("/settings")
public String viewSettings(Model model) {
  // do stuff
  model.addAttribute("classActiveSettings","active");
  return "settings";
}