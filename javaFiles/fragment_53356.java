public final class MyRunnable implements Runnable {
        public void run() {
            System.out.println("running...");
            // etc...
        }
    }

    final Class runnableClass = classLoader.loadClass("classloader.MyRunnable");
    final Thread thread = new Thread((Runnable) runableClass.newInstance());

    thread.setContextClassLoader(classLoader); // this is unnecessary unless you you are using libraries that themselves call .getContextClassLoader()

    thread.start();