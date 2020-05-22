...
preferredHeight = Math.max(preferredHeight, getSuggestedMinimumHeight());
preferredWidth = Math.max(preferredWidth, getSuggestedMinimumWidth());

heightSize = resolveSizeAndState(preferredHeight, heightMeasureSpec, 0);
widthSize = resolveSizeAndState(preferredWidth, widthMeasureSpec, 30);

setMeasuredDimension(widthSize, heightSize);
...