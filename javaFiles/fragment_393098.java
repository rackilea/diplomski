// note that it is declared to return myAnimation type
public MyAnimations rotate(int duration, int repeat) {
    animation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    animation.setRepeatCount(repeat);
    animation.setDuration(duration);
    return this;
}