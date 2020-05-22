public class Controller {

    private Map<String, Function<String, List<User>>> handlers = new HashMap<>();

    {
        handlers.put("userId", id -> getUsersById(Integer.valueOf(id)));
        handlers.put("userType", type -> getUsersByType(User.Type.valueOf(type)));
        handlers.put("userAge", age -> getUsersByAge(Integer.valueOf(age)));
    }

    @RequestMapping("...")
    public ResponseEntity<List<User>> getList(@RequestParam Map<String, String> params) {
        if (params.size() > 1) {
            return ResponseEntity.unprocessableEntity().build();
        }

        if (params.size() == 0) {
            return ResponseEntity.ok(getAllWithoutCondition());
        }

        Map.Entry<String, String> paramEntry = params.entrySet().iterator().next();

        return ResponseEntity.ok(handlers.get(paramEntry.getKey()).apply(paramEntry.getValue()));
    }

    private List<User> getAllWithoutCondition() { ... }

    private List<User> getUsersById(Integer id) { ... }
    private List<User> getUsersByType(User.Type type) { ... }
    private List<User> getUsersByAge(Integer age) { ... }

}