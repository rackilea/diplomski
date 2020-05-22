final WindowManager.LayoutParams param=new WindowManager.LayoutParams();
param.flags=WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
final View view=findViewById(R.id.my_floating_view);
final ViewGroup parent=(ViewGroup)view.getParent();
if(parent!=null)
  parent.removeView(view);
param.format=PixelFormat.RGBA_8888;
param.type=WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
param.gravity=Gravity.TOP|Gravity.LEFT;
param.width=parent!=null?LayoutParams.WRAP_CONTENT:view.getLayoutParams().width;
param.height=parent!=null?LayoutParams.WRAP_CONTENT:view.getLayoutParams().height;
final WindowManager wmgr=(WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
wmgr.addView(view,param);
// TODO handle overlapping title bar and/or action bar
// TODO you must add logic to remove the view
// TODO you must use a special permission to use this method :android.permission.SYSTEM_ALERT_WINDOW
// TODO if you wish to let the view stay when leaving the app, make sure you have a foreground service running.