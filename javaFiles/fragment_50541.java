AnimatorListenerAdapter onEnd = new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator _a) {
            DropZone.this.setTranslationY(getHeight() + 2);
            DropZone.this.setAlpha(0f);
        }
    };