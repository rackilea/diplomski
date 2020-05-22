@PostMapping("/test")
    public boolean test(@RequestBody TestModel model) {

        System.out.println(model.getCategory());
        System.out.println(model.getName());
        JSONObject jsonObj = new JSONObject(model.getJsonObj());
        System.out.println(jsonObj);

        return true;
    }