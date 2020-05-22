public class IntArrayViaJNI {
      private static boolean loaded = false;
      private native int[] intArrayMethod(float[] t, int nb_of_subscribers, int tags);

      public int[] getIntArray(float[] t, int nb_of_subscribers, int tags) {
          // Although this portion should be in a synchronized method,
          // e.g. ensureLibraryLoaded().
          if (!loaded) {
            System.loadLibrary("mylib");
            loaded = true;
          }
          return intArrayMethod(t, nb_of_subscribers, tags);
      }
    }