public void AddViewToContainer(View view){

    ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.containerfordynamic_view);

    layout.addView(view);

}

public void RemoveViews() {

    ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.containerfordynamic_view);

    layout.removeAllViews();

}