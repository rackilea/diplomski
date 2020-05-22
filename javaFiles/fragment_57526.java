button.setOnClickListener(v -> {
    ConstraintLayout.LayoutParams params = 
            (ConstraintLayout.LayoutParams) viewToRemove.getLayoutParams();

    parent.removeView(viewToRemove);
    parent.addView(viewToAdd, params);
});