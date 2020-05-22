public static void reverse(ArrayList<Integer> list){
        Integer [] reverse = new Integer[list.size()];
        for (int i=list.size()-1; i>=0; i--){
            reverse[i]= list.get(i);

            System.out.println (reverse[i]);
        }

    }