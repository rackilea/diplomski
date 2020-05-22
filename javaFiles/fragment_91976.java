@RequestMapping(method = POST, value = "changerole")
@ResponseBody
        public ResponseEntity<String> changeRole(@RequestBody String jsonData) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map;
        map = mapper.readValue(jsonData, HashMap.class);
        String role = map.get("role");
        String id = map.get("id");
        User user= userDAO.findById(Integer.valueOf(id));
        user.setRole(role);
        userDAO.update(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<String>("{\"msg\":\"success\"}", headers, HttpStatus.OK);
        }