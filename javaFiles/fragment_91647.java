final LinearLayout ll1=(LinearLayout)findViewById(R.id.ll1);
ll1.post(new Runnable()
    {
       public void run()
         {
            Rect rect= new Rect();
            Window window= getWindow(); ll1.getWindowVisibleDisplayFrame(rect);
            int statusBarHeight= rect.top;
            Log.e("", "ht of sb  bar is "+statusBarHeight);
            int contentViewTop= window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
            int titleBarHeight= contentViewTop - statusBarHeight;
            Log.e("", "ht of title bar is "+titleBarHeight);
         }
    });