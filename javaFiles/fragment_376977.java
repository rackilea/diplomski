public void fitAllIn(float[] boundingMinMaxWorldSpace) {

        Vec4 centerWorldSpace = new Vec4((boundingMinMaxWorldSpace[0] + boundingMinMaxWorldSpace[1]) / 2,
                (boundingMinMaxWorldSpace[2] + boundingMinMaxWorldSpace[3]) / 2,
                (boundingMinMaxWorldSpace[4] + boundingMinMaxWorldSpace[5]) / 2, 1f);

        Vec3 min = new Vec3(boundingMinMaxWorldSpace[0], boundingMinMaxWorldSpace[2], boundingMinMaxWorldSpace[4]);
        Vec3 max = new Vec3(boundingMinMaxWorldSpace[1], boundingMinMaxWorldSpace[3], boundingMinMaxWorldSpace[5]);

        float diameter = (float) Math.sqrt(
                (max.x - min.x) * (max.x - min.x)
                + (max.y - min.y) * (max.y - min.y)
                + (max.z - min.z) * (max.z - min.z));

        if (getCurrView().orthographicProj) {

            if (glViewer.getAspect() > 1) {
                // projection * scale = y
                getCurrView().scale = diameter / 2 / projectionSide;

            } else {
                // projection * aspect * scale = x
                getCurrView().scale = diameter / 2 / (projectionSide * glViewer.getAspect());
            }
            getCurrView().scale = viewScale.clampScale(projectionSide, getCurrView().scale);
        }
    getCurrView().targetPos = new Vec3(centerWorldSpace);

    glViewer.refresh();