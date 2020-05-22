@RequestMapping(value = "/addUserToProject", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody
String Submit(@RequestParam("projectId") Integer projectId ,@RequestParam("userId ") Integer userId ) {

   //insert user

    return "ok";
}