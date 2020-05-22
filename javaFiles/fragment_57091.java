AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.anim_yours);

    List<Animator> animators = animatorSet.getChildAnimations();
    for (int i = 0; i < animators.size(); i++) {
        Animator animator = animators.get(i);
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            if ("rotationY".equals(objectAnimator.getPropertyName())) {
                float fromValue = -100;
                float toValue = 0;
                objectAnimator.setFloatValues(fromValue, toValue);
            }
        }
    }
    // and you use changed AnimoatorSet..