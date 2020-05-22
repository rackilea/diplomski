protected void startActivity(Class<?> clase) {
    final Intent i = new Intent(this, clase);
    int flags = Intent.FLAG_ACTIVITY_CLEAR_TOP;
    flags |= Intent.FLAG_ACTIVITY_NEW_TASK;
    i.setFlags(flags);
    startActivity(i);
}


startActivity(ActivityD.class);