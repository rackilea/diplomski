MyClass toValidate = new MyClass();
DataBinder binder = new DataBinder(toValidate);
binder.setValidator(new MyValidator());
binder.validate();
if (binder.getBindingResult().hasErrors()) {
    // oh noes!
}