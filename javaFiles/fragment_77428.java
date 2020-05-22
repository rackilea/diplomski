ValueAnimator animator = new ValueAnimator();
                    animator.setObjectValues(0, percentage);
                    animator.addUpdateListener(new AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator animation) {
                            prog.setText("Profile Progress: "+String.valueOf(animation.getAnimatedValue())+"%");
                        }
                    });
                    animator.setEvaluator(new TypeEvaluator<Integer>() {
                        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                            return Math.round((endValue - startValue) * fraction);
                        }
                    });
                    animator.setDuration(1500);
                    animator.start();