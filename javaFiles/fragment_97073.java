@RequestMapping("/test", produces="application/json")
@ResponseBody
public String test() {
        JsonObject result = Json.createObjectBuilder()
                .add("name", "Dade")
                .add("age", 23)
                .add("married", false)
                .build();
        return result.toString();
}