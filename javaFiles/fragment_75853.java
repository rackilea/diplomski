mPathDiamondStamp = new Path();
        mPathDiamondStamp.moveTo(-DIAMOND_WIDTH / 2, 0);
        mPathDiamondStamp.lineTo(0, DIAMOND_HEIGHT / 2);
        mPathDiamondStamp.lineTo(DIAMOND_WIDTH / 2, 0);
        mPathDiamondStamp.lineTo(0, -DIAMOND_HEIGHT / 2);
        mPathDiamondStamp.close();

        mPathDiamondStamp.moveTo(-DIAMOND_WIDTH / 2 + DIAMOND_BORDER_WIDTH, 0);
        mPathDiamondStamp.lineTo(0, -DIAMOND_HEIGHT / 2 + DIAMOND_BORDER_WIDTH / 2);
        mPathDiamondStamp.lineTo(DIAMOND_WIDTH / 2 - DIAMOND_BORDER_WIDTH, 0);
        mPathDiamondStamp.lineTo(0, DIAMOND_HEIGHT / 2 - DIAMOND_BORDER_WIDTH / 2);
        mPathDiamondStamp.close();

        mPathDiamondStamp.setFillType(Path.FillType.EVEN_ODD);

        mDiamondPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDiamondPaint.setColor(Color.BLUE);
        mDiamondPaint.setStrokeWidth(2);
        mDiamondPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mDiamondPaint.setStyle(Paint.Style.STROKE);
        mDiamondPaint.setPathEffect(new PathDashPathEffect(mPathDiamondStamp, DIAMOND_ADVANCE, DIAMOND_PHASE, PathDashPathEffect.Style.ROTATE));