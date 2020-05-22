public static void main(String[] args) {
        int[] adio = {6, 12, 4, 5, 3, 8, 7};
        // `String.valueOf(adio)` returns something like "[I@7a9273a8"
        Scanner ini = new Scanner(String.valueOf(adio));
        // `nextInt()` fails when scanning from "[I@7a9273a8"
        int n = ini.nextInt();
        int[] a = new int[n];
        for(int i=0; i < a.length; i++){
            a[i] = ini.nextInt();
        }
        getMedians(a);
    }