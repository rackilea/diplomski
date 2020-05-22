Scanner scan = null;
        try {
            int n, sum = 0, max, min;
            double average = 0;
            scan = new Scanner(System.in);
            System.out.println("Enter elements you want to input in array: ");
            n = scan.nextInt();
            int a[] = new int[n];
            max = a[0];
            System.out.println("Enter all the elements:");
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
                sum += a[i];
                average = (double) sum/a.length;
                if (a[i] > max) {
                    max = a[i];
                }
                /**
                // from here remove logic for get min value.
                if (a[i] < min) {
                   min = a[i];
                }
                **/
            }
            min = a[0];
            for(int i=0;i<a.length;i++){
                if(a[i] < min){
                  min = a[i];
                }
              }
            System.out.println("Sum is: " + sum);
            System.out.println("Average is: " + average);
            System.out.println("Max is: " + max);
            System.out.println("Min is: " + min);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            scan.close();
        }