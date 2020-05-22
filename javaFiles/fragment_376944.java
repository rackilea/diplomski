Intent intent = new Intent();

//com.colisa.broadcast is the package of another app
//com.colisa.broadcast.MainActivity is the actity to be launched
intent.setComponent(
   new ComponentName("com.colisa.broadcast","com.colisa.broadcast.MainActivity"));