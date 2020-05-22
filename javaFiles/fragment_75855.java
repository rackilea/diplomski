mBorderPath = new Path();
        LatLng firstBorderPoint = mBorderPoints.get(0);
        PointF firstScreenPoint = mMapboxMap.getProjection().toScreenLocation(firstBorderPoint);
        mBorderPath.moveTo(firstScreenPoint.x, firstScreenPoint.y);

        for (int ixPoint = 1; ixPoint < mBorderPoints.size(); ixPoint++) {
            PointF currentScreenPoint = mMapboxMap.getProjection().toScreenLocation(mBorderPoints.get(ixPoint));
            mBorderPath.lineTo(currentScreenPoint.x, currentScreenPoint.y);
        }