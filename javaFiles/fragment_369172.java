RotateAnimation anim = new RotateAnimation(0, 45, Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

anim.setInterpolator(new LinearInterpolator());
anim.setDuration(500);
anim.setFillEnabled(true);
anim.setFillAfter(true);

image.startAnimation(anim)