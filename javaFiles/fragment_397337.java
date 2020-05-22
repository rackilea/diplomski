`int[] list = new int[10];
    int[] num = new int[10];
    for(int i = 0; i< list.length;i++) {
        list[i] = (int)(Math.random()*10);
    }
    for(int i = 0; i< list.length;i++) {
        System.out.print(list[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < list.length; i++) {
        ++num[list[i]];
    }
    for (int i = 0; i < num.length; i++) {
        if(num[i]>0){
            System.out.printf("%d occurs %d times\n",i,num[i]);
        }
    }`