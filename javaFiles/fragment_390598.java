public static void zeroDistance (int[] a)
{
    List<Integer> zerosCoordinates = new ArrayList<>();

    for (int i = 0; i < a.length; i++) {

        if (a[i] == 0)
            zerosCoordinates.add(i);
    }

    for(int i : zerosCoordinates) {

        for (int j = i - 1, k = 1; j >= 0; j--, k++) {

            if (a[j] == 0)
                break;

            if (a[j] != 0 && a[j] < k)
                a[j] = k;
        }
    }

    for (int i : zerosCoordinates) {

        for (int j = i + 1, k = 1; j < a.length; j++, k++) {

            if (a[j] == 0)
                break;

            if (a[j] != 0 && a[j] > k || j == a.length - 1)
                a[j] = k;
        }
    }

    for (int i = 0; i < a.length; i++)
        System.out.print(a[i]);
}