public static Result myActionUsingModel() {
    MyViewModel data = new MyViewModel();
    data.pageTitle = "Ellou' World!";
    data.counter = 123;

    return ok(myViewUsingModel.render(data));
}