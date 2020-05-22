for(Future<String[][]> future : set){
        String[][] result = future.get();
        for (String[] strArr: result){
            for (String str: strArr){
                System.out.println(str);
            }
        }
    }