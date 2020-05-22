@RequestMapping(value="/user", method = POST)
public String addFromForm(@Valid @ModelAttribute("box") Man man, BindingResult bindingResult){
    if (bindingResult.hasErrors()) {
        return "param";
    }
    manService.saveMan(man);
   return "redirect:../list";
}