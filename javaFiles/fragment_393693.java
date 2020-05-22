@Override
    protected void onDraw(Canvas canvas) {
        if (mData == null) {    
            boolean hasText = !TextUtils.isEmpty(mNoDataText);    
            if (hasText) {
                MPPointF c = getCenter();
                canvas.drawText(mNoDataText, c.x, c.y, mInfoPaint);
            }    
            return;
        }

        if (!mOffsetsCalculated) {

            calculateOffsets();
            mOffsetsCalculated = true;
        }
    }