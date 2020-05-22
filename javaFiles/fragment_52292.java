drawView.animate().translationXBy((-720f)/j)
                                        .setDuration(1000).setListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {
                                        j++;
                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        drawView.animate().translationXBy((-720f) / j).setDuration(1000);
                                    }

                                    @Override
                                    public void onAnimationCancel(Animator animation) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animation) {

                                    }
                                });