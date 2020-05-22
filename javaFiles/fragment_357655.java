public Result myControllerMethod(){
  ...
  //handle input text here
  Form<MyModel> myForm = formFactory.form(MyModel.class);
  MyModel myModel = myForm.bindFromRequest().get();
  ...
  //handle file
  MultipartFormData<File> body = request().body().asMultipartFormData();
  ...
}