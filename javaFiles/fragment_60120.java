public static void main (String[] args) throws java.lang.Exception
{
    int [] list;
    int temp;   
    list = new int[5];
    list[0] = 4; 
    list[1] = 5;
    list[2] = 12;
    list[3] = 9;
    list[4] = 3;
    boolean flag = true;

    do {
        flag = false;
            for (int i = 0; i < list.length-1; ++i) {
                if (list[i] > list[i + 1]) {

                    //replaces your swap
                    temp = list[i];                
                    list[i] = list[i+1];
                    list[i+1] = temp;

                    flag = true;
                }

            }
        }
        while (flag == true);
        System.out.println(Arrays.toString(list));
    }
}