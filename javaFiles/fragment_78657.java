Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.slide_left_to_right);

final long startOffset = position * 75;
animation.setStartOffset(startOffset);

tvLesson.startAnimation(animation);