mRecommendButton = (Button)v.findViewById(R.id.recommended_button);
        StateListDrawable background = (StateListDrawable) mRecommendButton.getCompoundDrawables()[1]; // Drawable set as drawableTop in xml
        Drawable drawable = background.getCurrent();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }