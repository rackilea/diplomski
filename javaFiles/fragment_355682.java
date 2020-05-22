Fade fade = new Fade();
fade.setDuration(500);
//exclude toolbar
fade.excludeTarget(R.id.toolbar, true);
//exclude status bar
fade.excludeTarget(android.R.id.statusBarBackground, true);
//exclude navigation bar
fade.excludeTarget(android.R.id.navigationBarBackground, true);

getWindow().setEnterTransition(fade);