@RequestMapping("/readmessage")
public String readMessage(@ModelAttribute("message") Message message,
  ModelMap map) {
    some_message_object = someService.getMessage() ;
    map.addAttribute("message", some_message_object) ;
}