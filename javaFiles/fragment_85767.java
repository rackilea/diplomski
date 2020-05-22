ModuleFinder finder = ModuleFinder.of(Paths.get("/path/to/module/in/out/production/")); // this is generally a path where I build my modules to

ModuleLayer parent = ModuleLayer.boot();

Configuration cf = parent.configuration()
                         .resolve(finder, ModuleFinder.of(), Set.of("one")); // name of module in module-info

ClassLoader scl = ClassLoader.getSystemClassLoader();
ModuleLayer layer = parent.defineModulesWithManyLoaders(cf, scl);

layer.modules()
     .stream()
     .map(Module::getDescriptor) // get the descriptor of module
     .map(ModuleDescriptor::requires) // set of requires in the module dependencies
     .forEach(System.out::println);