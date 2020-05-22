String in = "John Appleseed William";
         String arr[] = in.split (" ");
         if (arr.length == 2) {
             System.out.println(arr[1] + ", " + arr[0]);
         }
         if (arr.length == 3) {
             System.out.println(arr[2] + ", " + arr[0] + " " + arr[1]);
         }