import java.util.ArrayList;
class lists{
     public static void findLagrestList() {
            int arr[][] = {{1,3},{3,1},{2,0},{4,4},{5,3},{6,2}};

            //ArrayList<int[]> currentSublist = new ArrayList<>();
            ArrayList<int[]> resultSublist = new ArrayList<>();

            int result_arr[][]={};

            int sum =0;
            for(int i=0;i<arr.length;i++)
            {
                int [] inner_arr =arr[i];
                int valuesum =arr[i][0]+arr[i][1];
                if(valuesum>sum)
                {
                    if(resultSublist.size()>0)
                    {
                        for(int k=0;k<resultSublist.size();k++)
                        {
                            int [] cvalue = resultSublist.get(k);
                            int summ=cvalue[0]+cvalue[1];
                            if(valuesum>summ)
                            {
                               resultSublist.remove(k) ;
                            }

                        }
                        resultSublist.add(inner_arr);
                    }else{
                        resultSublist.add(inner_arr);
                        sum = valuesum;
                    }
                }
            }



System.out.println(resultSublist.size());
printList(resultSublist);

}

    private static void printList(ArrayList<int[]> list) {

        for (int[] is : list) {
            System.out.println();
            for (int i : is) {
                System.out.print(i + " ");

            }
        }
    }

    public static void main(String [] oo)
    {
         lists.findLagrestList();
    }

}