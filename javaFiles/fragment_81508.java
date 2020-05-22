public static Result submit() {
    Form<User> userForm = Form.form(User.class).bindFromRequest();
    ObjectNode output = Json.newObject();

    if (userForm.hasErrors()) {
        output.put("status", 400);
        output.put("errors", userForm.errorsAsJson());
        return badRequest(output);
    }

    output.put("status", 200);
    output.put("msg", "Your account was registered correctly!");
    return ok(output);

}