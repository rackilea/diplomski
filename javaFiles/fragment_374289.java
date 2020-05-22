public void onClick(View view) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("adminInterface", adminInterface);
    Intent intent = new Intent(appContext, AdminControls.class);
    intent.putExtras(bundle);
    appContext.startActivity(intent);
}