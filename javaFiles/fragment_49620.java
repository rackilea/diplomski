private FormViewBuilder(Context context) {
    this.context = context;
    formView = new FormView(context); // initialize
    // ...
}

// ...

public FormViewBuilder addField(int id, @NonNull String key, @NonNull String hint, String requiredMessage) {
    TextInputLayout field = newTextField(context, id, key, hint, requiredMessage);
    getLastRow().add(field);

    // add views before build <<================ important
    ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.CHAIN_SPREAD,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
    );
    formView.addView(field, params);

    return this;
}


public FormView build() {
    ConstraintSet constraints = new ConstraintSet();
    constraints.clone(formView); // clone after views are added <<================ important

    // only set constraints. do not add or remove views

    constraints.applyTo(formView);
    return formView;
}