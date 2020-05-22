MapBinder<Integer, Bar> mapbinder
     = MapBinder.newMapBinder(binder(), Integer.class, Bar.class);
mapbinder.addBinding(1).to(BarImpl1.class);
mapbinder.addBinding(2).to(BarImpl2.class);

bind(Bar.class).to(BarImpl.class); // the fallback