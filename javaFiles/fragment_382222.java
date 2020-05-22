WindowManager.LayoutParams param_txt = (WindowManager.LayoutParams) layoutView.getLayoutParams();

param_txt.x = [xPosition of TextView]
param_txt.y = [yPosition of TextView]

if(layoutView.isAttachedToWindow()) {
      exampleTextLayout.setVisibility(View.VISIBLE);
      windowManager.updateViewLayout(exampleTextLayout, param_txt);
}