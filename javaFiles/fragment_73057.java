private void createUiChangeListener() {

    decorView.setOnSystemUiVisibilityChangeListener (
            new View.OnSystemUiVisibilityChangeListener() {

                @Override
                public void onSystemUiVisibilityChange(int pVisibility) {

                    if ((pVisibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        decorView.setSystemUiVisibility(uiOptions);
                    }

                }

            });

}