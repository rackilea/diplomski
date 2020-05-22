public static void s3(int len) {
    for (int i = 0; i <= len; i++) {
        for (int j = len; j > i; j--) {
            System.out.print(" ");
        }

        for (int j = 0; j < len - (len - i); j++) {
            System.out.print(" *");
        }

        System.out.println("");
    }
    for (int i = 0; i <= len; i++) {

        for (int j = 0; j < (i); j++) {
            System.out.print(" ");

        }

        for (int j = len; j > i; j--) {
            System.out.print(" *");

        }

        System.out.println("");
    }

}