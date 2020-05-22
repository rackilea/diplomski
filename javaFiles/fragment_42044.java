for(int i =0;i< array.size(); ++i){
        if(array.contains(value - array.get(i)))
        {
            System.out.println((value - array.get(i)) +" + "+ array.get(i) + " = " + value);
        }
    }