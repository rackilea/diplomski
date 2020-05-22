public static Result saveBlank(){
    signupForm = signupForm.bindFromRequest();
    if (signupForm.hasErrors()){
        return badRequest(form.render(signupForm));
    }

    User user = new User();
    user = signupForm.get();
    user.save();

    return ok("user saved");
}