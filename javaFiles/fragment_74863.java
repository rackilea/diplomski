Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char arr[][] = new char[n][n];
        String a;

        for (int i = 0; i < n; i++) {
            a = in.next(); //Eneter the sting

            for (int k = 0; k < n; k++) {

                arr[i][k] = a.charAt(k); //i get the character in the array
            }

        }
        System.out.println(Arrays.deepToString(arr));

// print indexes
        for (int i = 0; i < n; i++) {

                System.out.println("Line " + i);

                for (int k = 0; k < n; k++) {

                    if (arr[i][k] == '#') {
// (print i+1 and k+1 instead of i and k, if you prefer)
                        System.out.print(i + " " + k);
                    }
                }

                System.out.println();

            }