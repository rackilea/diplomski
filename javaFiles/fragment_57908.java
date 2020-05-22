for (int i=0;i<a.length;i++) {
        ArrayList<Integer> temp = map.get(a1[i]);
        Collections.sort(temp);
        for(int j=0;j<temp.size();j++) {
            a[i]=temp.get(j);
            if (j<temp.size()-1)
                i++;
        }
    }