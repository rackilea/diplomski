public static class LoadClassFromByteData extends ClassLoader {

        final ConcurrentHashMap<String, Class<?>> definedClassesByName = new ConcurrentHashMap<>();

        LoadClassFromByteData(ClassLoader parent) {
            super(parent);
        }

        public Class<?> getLoadedClass(String className, byte[] classAsBytes) {

            return this.definedClassesByName.computeIfAbsent(className,
                    cn -> defineClass(cn, classAsBytes, 0, classAsBytes.length));
        }
    }

    @Test
    public void test() throws IOException, InstantiationException, IllegalAccessException {

        final byte[] sampleClass1Bytes = Files.readAllBytes(SAMPLE_CLASS1_CLASS_FILE_PATH);
        final byte[] sampleClass2Bytes = Files.readAllBytes(SAMPLE_CLASS2_CLASS_FILE_PATH);

        final ClassLoader contextClassLoader = Thread.currentThread()
            .getContextClassLoader();
        final LoadClassFromByteData loadClassFromByteData = new LoadClassFromByteData(contextClassLoader);
        final Class<?> sampleClass1 = loadClassFromByteData.getLoadedClass("package1.SampleClass1", sampleClass1Bytes);
        final Object sampleClass1Instance = sampleClass1.newInstance();
        final Class<
            ?> sampleClass2 = loadClassFromByteData.getLoadedClass("package1.package2.SampleClass2", sampleClass2Bytes);
        final Object newInstance = sampleClass2.newInstance();
    }