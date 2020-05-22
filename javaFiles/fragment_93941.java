public Generator getGenerator (final String type)
{
    final Class generatorClass = ClassLoader.getSystemClassLoader().loadClass("Generator"+type);
    final Generator generator = (Generator) (generatorClass.newInstance());
     return generator;
}