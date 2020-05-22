Animation animRotate= AnimationUtils.loadAnimation(context, R.anim.image_rotate);
Animation fade_in = AnimationUtils.loadAnimation(context, R.anim.fade_in);
Animation fade_out = AnimationUtils.loadAnimation(context, R.anim.fade_out);

AnimationSet s = new AnimationSet(false);
s.addAnimation(fade_in);

animRotate.setDuration((long) duration);
animRotate.setStartOffset(fade_in.getDuration());
s.addAnimation(animRotate);

fade_out.setStartOffset(fade_in.getDuration() + animRotate.getDuration());
s.addAnimation(fade_out);

s.setFillAfter(true);

image.startAnimation(s);