// Set Menu Click Listener 
bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
        @Override
        public Unit invoke(MeowBottomNavigation.Model p1) {
            return Unit.INSTANCE;
        }
    });

// Set Menu Show listener
bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
        @Override
        public Unit invoke(MeowBottomNavigation.Model s) {
            return Unit.INSTANCE;
        }
    });