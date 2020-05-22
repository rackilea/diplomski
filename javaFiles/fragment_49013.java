int[] a = new int[] {-1,3,-4,2,5};
    int[] tmp = a.clone();

    Arrays.sort(tmp);
    int max = tmp[tmp.length-1];
    int low = tmp[0];
    int last =max;
    if(low<0) {
        last=max-low;
    }

    for (int i = 0; i < last+1; i++) {
        for (int j = 0; j < a.length; j++) {        
            if (i == last ) {
                System.out.print(a[j]);
            } else if(i<max){        
                if (i < max - a[j])
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            else {
                if (i < max - a[j] )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
        }
        System.out.println();
    }
}