String[] name = new String[10];
name[0] = ...;
name[1] = ...; // etc

// Some other code.

random = name[new Random().nextInt(name.length)];