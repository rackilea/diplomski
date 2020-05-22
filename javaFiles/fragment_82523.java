int c=2;
        int temp1, temp2;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 'n': ");
        int n = in.nextInt();

        int[ ][ ] arr = new int[n][c];

        if (n<=15) {
            for(int i=0; i<n;i++) {
                for (int j=0;j<c;j++) {
                    System.out.println("Enter values into md-array: ");
                    arr[i][j]=in.nextInt();
                    }   
            }
            System.out.println("====================================================");
            for(int i[]: arr){
                for(int j: i){
                    System.out.print(j+"   ");
                }
                System.out.println("");
            }
            System.out.println("====================================================");
            for(int i=0; i<n;i++) {
                for (int j=0;j<c-1;j++) {
                  if (arr[i][j]<arr[i][j+1]) {
//                      System.out.println(arr[i][j]);      
                  }
                  else {
                      temp2=arr[i][j]; //swapping
                      arr[i][j]=arr[i][j+1];
                      arr[i][j+1]=temp2;

//                      System.out.println(arr[i][j]);
                  }
                }
            }
            for(int i[]: arr){
                for(int j: i){
                    System.out.print(j+"   ");
                }
                System.out.println("");
            }
        }