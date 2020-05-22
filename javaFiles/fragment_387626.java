ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> list1=new ArrayList<Integer>();
        Random r1=new Random();
        int[] images = new int[] {R.drawable.a, R.drawable.f, R.drawable.k,
                R.drawable.u, R.drawable.y, R.drawable.w, R.drawable.t, R.drawable.g,
                R.drawable.b, R.drawable.o};
        int[] images2 = new int[] {  R.drawable.apple, R.drawable.fan,
                R.drawable.kite, R.drawable.umbrells,
                R.drawable.yark,R.drawable.watch, R.drawable.tap,
                R.drawable.gun, R.drawable.ball, R.drawable.orange};
        for(int i=0;i<4;i++)
        {
            while(true)
            {
                int next=r1.nextInt(10)+1;
                if(!list.contains(next))
                {
                list.add(images[next]);
                list1.add(images2[next]);
                break;
                }
            }
        }
        array1 = convertIntegers(list);
        array2 = convertIntegers(list1);