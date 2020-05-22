// Draw the exterior (i.e. outside the framing rect) darkened
paint.setColor(resultBitmap != null ? resultColor : maskColor);
canvas.drawRect(0, 0, width, frame.top, paint);
canvas.drawRect(0, frame.top, frame.left, frame.bottom + 1, paint);
canvas.drawRect(frame.right + 1, frame.top, width, frame.bottom + 1, paint);
canvas.drawRect(0, frame.bottom + 1, width, height, paint);