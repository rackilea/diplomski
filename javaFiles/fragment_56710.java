public static void loopy_loop(int[] source, int[] destination, int level, int startIndex) {

    for (int i = startIndex; i < source.length - destination.length + level + 1; i++) {
        destination[level] = source[i];
        if (level == destination.length - 1)
        {
            String rez = String.valueOf(destination[0]);
            for (int j = 1; j < destination.length; j++)
                rez += ", " + destination[j];
            System.out.println("{"+ rez +"}");
        }
        else
            loopy_loop(source, destination, level + 1, i + 1);
    }

}