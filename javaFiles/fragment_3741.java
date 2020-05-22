for(int r = 0; r < data.size(); r++)
 {
    System.out.print("Row " + (r+1) + ": ");
    for(Integer num : data.get(r)) {
       System.out.print(num + " ");
    }
    System.out.println(); //to end the line
 }