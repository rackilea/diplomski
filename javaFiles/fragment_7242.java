RollingStock freightCoach = StoregeManager.getFreightCoach();
RollingStock specialCoach = StoregeManager.getSpecialCoach();
RollingStock dieselEngine = StoregeManager.getDieselEngine();

// Check if they are null or throw an exception if has no more elements. Maybe from BBDD or from where you want

Composer.compone()
.add(dieselEngine)
.add(freightCoach)
.add(specialCoach)
.build()