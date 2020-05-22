@Override
public void render() {
    if (render) {
        // Clear color and depth buffer
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        // Get the state from Vuforia and mark the beginning of a rendering
        // section
        State state = Renderer.getInstance().begin();
        // Explicitly render the Video Background
        Renderer.getInstance().drawVideoBackground();

        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        // We must detect if background reflection is active and adjust the
        // culling direction.
        // If the reflection is active, this means the post matrix has been
        // reflected as well,
        // therefore standard counter clockwise face culling will result in
        // "inside out" models.
        GLES20.glEnable(GLES20.GL_CULL_FACE);
        GLES20.glCullFace(GLES20.GL_BACK);
        cam.update();
        modelBatch.begin(cam);

        if (Renderer.getInstance().getVideoBackgroundConfig().getReflection() == VIDEO_BACKGROUND_REFLECTION.VIDEO_BACKGROUND_REFLECTION_ON)

                        GLES20.glFrontFace(GLES20.GL_CW);  // Front camera
        else
            GLES20.glFrontFace(GLES20.GL_CCW);   // Back camera

        // Set the viewport
        int[] viewport = vuforiaAppSession.getViewport();
        GLES20.glViewport(viewport[0], viewport[1], viewport[2], viewport[3]);

        // Did we find any trackables this frame?
        for (int tIdx = 0; tIdx < state.getNumTrackableResults(); tIdx++)
        {
            // Get the trackable:
            TrackableResult trackableResult = state.getTrackableResult(tIdx);
            float[] modelViewMatrix = Tool.convertPose2GLMatrix(
                    trackableResult.getPose()).getData();

            // Choose the texture based on the target name:
            int textureIndex = 0;

            // Check the type of the trackable:
            assert (trackableResult.getType() == MarkerTracker.getClassType());
            MarkerResult markerResult = (MarkerResult) (trackableResult);
            Marker marker = (Marker) markerResult.getTrackable();
            textureIndex = marker.getMarkerId();
            float[] modelViewProjection = new float[16];
            Matrix.translateM(modelViewMatrix, 0, -kLetterTranslate, -kLetterTranslate, 0.f);
            Matrix.scaleM(modelViewMatrix, 0, kLetterScale, kLetterScale, kLetterScale);
            Matrix.multiplyMM(modelViewProjection, 0, vuforiaAppSession.getProjectionMatrix().getData(), 0, modelViewMatrix, 0);
            SampleUtils.checkGLError("FrameMarkers render frame");
            cam.view.idt();
            cam.projection.idt();
            cam.combined.idt();
            Matrix4 temp3 = new Matrix4(modelViewProjection);
            modelInstanceHouse.transform.set(temp3);
            modelInstanceHouse.transform.scale(0.05f, 0.05f, 0.05f);
            controller.update(Gdx.graphics.getDeltaTime());
            modelBatch.render(modelInstanceHouse);
        }
        GLES20.glDisable(GLES20.GL_DEPTH_TEST);
        modelBatch.end();

}