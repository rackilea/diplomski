Arrays.copyOf// is a Java 6 feature. For older versions switch to System.arrayCopy.

    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
              return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }