File jar = getJar(MyClass.class); // MyClass can be any class in you jar file
File dir = jar.getParentFile();
ProcessBuilder builder = new ProcessBuilder();
builder.command("lib\\a.exe");
builder.directory(dir);
...
Process p = builder.start();
...