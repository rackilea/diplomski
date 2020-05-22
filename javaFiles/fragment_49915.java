LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(getActivity(), R.drawable.card_background);
    GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.card_background);
    gradientDrawable.setColor(0xFF5ABC63);

    RelativeLayout layout = (RelativeLayout) rootView.findViewById(R.id.card_layout);
    layout.setBackground(layerDrawable);