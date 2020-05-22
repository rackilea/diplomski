// Create an instance of some View that does the actual drawing of the line
View customView = new CustomView(<some context>);

// Figure out the window we have to work with
Rect rect = new Rect();
getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

// Make sure the view is measured before doing this
int requestedHeight = customView.getLayoutParams().height;

// setup the params of the new view we'll attach
WindowManager.LayoutParams wlp = new WindowManager.LayoutParams(
     rect.width(), requestedHeight,
     WindowManager.LayoutParams.TYPE_APPLICATION_PANEL,
     WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | 
          WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
          WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
     PixelFormat.TRANSLUCENT);
// set the parameters so we fit on the top left of the window
wlp.x = 0;
wlp.y = rect.top;
wlp.gravity = Gravity.TOP;

// finally add it to the screen
getWindowManager().addView(header, wlp);