float radius = getResources().getDimension(R.dimen.roundcorner);
NavigationView navigationView = findViewById(R.id.nav_view);
MaterialShapeDrawable navViewBackground = (MaterialShapeDrawable) navigationView.getBackground();
    navViewBackground.setShapeAppearanceModel(
        navViewBackground.getShapeAppearanceModel()
            .toBuilder()
            .setTopRightCorner(CornerFamily.ROUNDED,radius)
            .setBottomRightCorner(CornerFamily.ROUNDED,radius)
            .build());