Properties master = new Properties();
master.load(masterInput);

Properties moduleA = new Properties();
moduleA.load(moduleAinput);
master.putAll(moduleA);

Properties moduleB = new Properties();
moduleB.load(moduleBinput);
master.putAll(moduleB);

// Now `master` contains the properties of all files.