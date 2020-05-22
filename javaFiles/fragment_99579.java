// Moderator controller
@RequestMapping(value = "/moderator")
public String moderator(Map<String, Object> model) {
  model.put("action", "/moderator/new-user-form");
  return "new-user-form";
}

// Admin controller
@RequestMapping(value = "/moderator")
public String moderator(Map<String, Object> model) {
  model.put("action", "/admin/new-user-form");
  return "new-user-form";
}