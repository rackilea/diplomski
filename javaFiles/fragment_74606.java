@RequestMapping(value = "/user",method = RequestMethod.GET)
@ResponseBody
    public ResponseEntity<Map<String,Object>> handleRequest() throws Exception{
        List<User> users = userService.list();          
        Map<String, Object> message = new HashMap<String, Object>();

        message.put("severity", "info");
        message.put("user", users);
        message.put("summary", "Not successfully.");
        message.put("code", 200);

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("success", true);
        json.put("message", message);

        return new ResponseEntity<Map<String,Object>>(message,HttpStatus.CREATED);
    }