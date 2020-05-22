drawable.draw(canvas);

// ---add the marker---
Bitmap marker = BitmapFactory.decodeResource(getResources(),
        R.drawable.search_marker_icon);
canvas.drawBitmap(marker, 40, 40, null);
Paint mPaint = new Paint();
mPaint.setColor(Color.RED);
canvas.drawCircle(60, 60, 5, mPaint);


        canvas.restore();
    }

    if (drawLock.availablePermits() <= 0) {
        drawLock.release();
    }
}
 super.onDraw(canvas);
}