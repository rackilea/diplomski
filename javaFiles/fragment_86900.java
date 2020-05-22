public void onDrawFrame(GL10 gl)
{
    // ...

    if (mVRMode)
    {
        Matrix.setIdentityM(mLeftEyeTranslate, 0);
        Matrix.setIdentityM(mRightEyeTranslate, 0);

        Matrix.translateM(mLeftEyeTranslate, 0, halfInterpupillaryDistance, 0.0F, 0.0F);

        Matrix.translateM(mRightEyeTranslate, 0, -halfInterpupillaryDistance, 0.0F, 0.0F);

        Matrix.multiplyMM(mLeftEye.getTransform().getEyeView(), 0, mLeftEyeTranslate, 0, mHeadTransform.getHeadView(), 0);

        Matrix.multiplyMM(mRightEye.getTransform().getEyeView(), 0, mRightEyeTranslate, 0, mHeadTransform.getHeadView(), 0);
    }

    // ...
}