File storage = getDir("all41", Context.MODE_PRIVATE);


    System.err.println("copying the android.jar from asssets to the internal storage to make it available to the compiler");
    BufferedInputStream bis = null;
    OutputStream dexWriter = null;
    int BUF_SIZE = 8 * 1024;
    try {
          bis = new BufferedInputStream(getAssets().open("android.jar"));
          dexWriter = new BufferedOutputStream(
              new FileOutputStream(storage.getAbsolutePath() + "/android.jar"));
          byte[] buf = new byte[BUF_SIZE];
          int len;
          while((len = bis.read(buf, 0, BUF_SIZE)) > 0) {
              dexWriter.write(buf, 0, len);
          }
          dexWriter.close();
          bis.close();

    } catch (Exception e) {
        System.err.println("Error while copying from assets: " + e.getMessage());
        e.printStackTrace();
    }


    System.err.println("instantiating the compiler and compiling the java file"); 
    org.eclipse.jdt.internal.compiler.batch.Main ecjMain = new org.eclipse.jdt.internal.compiler.batch.Main(new PrintWriter(System.out), new PrintWriter(System.err), false/*noSystemExit*/, null);
    ecjMain.compile(new String[] {"-classpath", storage.getAbsolutePath()+"/android.jar", Environment.getExternalStorageDirectory().getAbsolutePath() + "/Test.java"});


    System.err.println("calling DEX and dexifying the test class"); 
    com.android.dx.command.Main.main(new String[] {"--dex", "--output=" + storage.getAbsolutePath() + "/Test.zip", Environment.getExternalStorageDirectory().getAbsolutePath() + "/./Test.class"});


    System.err.println("instantiating DexClassLoader, loading class and invoking toString()");
    DexClassLoader cl = new DexClassLoader(storage.getAbsolutePath() + "/Test.zip", storage.getAbsolutePath(), null, getClassLoader());
    try {
        Class libProviderClazz = cl.loadClass("Test");
        Object instance = libProviderClazz.newInstance();
        System.err.println(instance.toString());
    } catch (Exception e) {
        System.err.println("Error while instanciating object: " + e.getMessage());
        e.printStackTrace();
    }