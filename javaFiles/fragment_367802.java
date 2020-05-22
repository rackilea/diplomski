for(int j = i+1; j < i; j++){
            if(list.get(i) > list.get(j)) {
                int big = list.get(i);
                int small = list.get(j);
                list.set(i, small);
                list.set(j, big);
            }