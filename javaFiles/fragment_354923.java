int[] monthlyTotals = new int[12];
 for (int i=0; i<trans_list.size(); i++)
 {
   //Add item at index i trans_list at location i in chart
   int chartXIndex =  Integer.parseInt(trans_list.get(i).getdate());
   monthlyTotals[chartXIndex] += trans_list.get(i).getAmount();
 }