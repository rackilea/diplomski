@RequestMapping(value = "/candidates/updateDisplayName", method = RequestMethod.POST)
public @ResponseBody String updateDisplayName(@RequestParam(value = "name") String displayName, HttpServletRequest request) {
    System.out.println("Update display name");
    System.out.println(displayName);
    return "";
}