// Create the module
@RealmModule(classes = { Person.class, Dog.class })
public class MyModule {
}

// Set the module in the RealmConfiguration to allow only classes defined by the module.
SyncConfiguration config = new SyncConfiguration.Builder(user, url)
  .modules(new MyModule())
  .build();

// It is possible to combine multiple modules to one schema.
SyncConfiguration config = new SyncConfiguration.Builder(user, url)
  .modules(new MyModule(), new MyOtherModule())
  .build();