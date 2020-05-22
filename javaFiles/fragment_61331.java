HashSet<AbstractModule> initialAms = new HashSet<AbstractModule>();
AbstractModule short1 = new AbstractModule("short1");
AbstractModule short2 = new AbstractModule("short2");
initialAms.add(short2);
initialAms.add(short1);
LV lv = new LV(initialAms);