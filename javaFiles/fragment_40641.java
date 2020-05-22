@RequestMapping(value = "/users", method = GET,produces = "application/xml")
   @ResponseBody
   public ResponseEntity<ResponseWrapper> getPartnersByDate(@RequestParam("type") String type, @RequestParam("id") String id) throws ParseException {

   List<User> usersList = userService.getUsersByType(type);
   ResponseWrapper wrapper = new ResponseWrapper(usersList);
   return new ResponseEntity<ResponseWrapper>(wrapper, HttpStatus.OK);
}