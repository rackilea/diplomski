URL u = new File("/home/adam/tmp").toURL();
    URLClassLoader loader = new URLClassLoader(new URL[] {u}, Test.class.getClassLoader());
    Class<? extends Enum> c = (Class<? extends Enum>) loader.loadClass("Color");
    PrintStream out = System.out;
    out.println("#ifndef COLOR_H");
    out.println("#define COLOR_H");
    for(Enum constant : c.getEnumConstants()) {
        out.println("#define " + c.getCanonicalName().replaceAll("\\.", "_") + "_" + constant.name() + " " + constant.ordinal());
    }
    out.println("#endif");