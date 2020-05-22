Map<String, Provider<Milkshake>> map = ...;
// Fill the map with providers, some of which could create a new instance,
// and some could reuse an existing one

...

Milkshake milkshake = map.get(text).get();