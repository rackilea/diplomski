private void showItem(int item){
        System.out.println(item+" contain ");
        for(String str:tMap.get(item) )
        {
            System.out.println( str);
        }
    }