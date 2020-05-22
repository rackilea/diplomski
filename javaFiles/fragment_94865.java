void spawnClass() {
   MyProps config = magicConfigurationLoad();
   MyClass a = new MyClass(config); // caches property xyz
   config.setProperty("xyz","bbq"); // change property xyz
   MyClass b = new Class(config); // caches the new value of xyz
}